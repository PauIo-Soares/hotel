package br.edu.fateczl.hotel.controller;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private DataSource dataSource;

    @GetMapping
    public String carregarForm(Model model) {
        return "relatorios";
    }

    @PostMapping("/quartosDisponiveis")
    public ResponseEntity gerarRelatorioQuartosDisponiveis(@RequestParam Map<String, String> params) {
        String erro = "";
        String data = params.get("data");

        Map<String, Object> relatorioParams = new HashMap<String, Object>();
        relatorioParams.put("data", data);

        byte[] bytes = null;

        InputStreamResource resource = null;
        HttpStatus status = null;
        HttpHeaders header = new HttpHeaders();

        Connection conn = DataSourceUtils.getConnection(dataSource);
        try{
            File arquivo = ResourceUtils.getFile("classpath:reports/DadosQuartos.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(arquivo.getAbsolutePath());
            bytes = JasperRunManager.runReportToPdf(report, relatorioParams, conn);
        } catch (Exception e) {
            erro = e.getMessage();
            status = HttpStatus.BAD_REQUEST;
        } finally {
            if(erro.equals("")){
                ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
                resource = new InputStreamResource(stream);
                header.setContentLength(bytes.length);
                header.setContentType(MediaType.APPLICATION_PDF);
                status = HttpStatus.OK;
            }
            return new ResponseEntity(resource, header, status);
        }
    }

}