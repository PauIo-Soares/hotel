USE db_hotel
GO

INSERT INTO tb_servicos (nome, descricao, valor)
VALUES
('Cafe da manha', 'Servico de cafe da manha completo no quarto', 50.00),
('Lavanderia', 'Servico de lavagem e passadoria de roupas', 80.00),
('Spa', 'Sessao de massagem relaxante no spa do hotel', 200.00),
('Translado', 'Transporte do aeroporto ate o hotel', 150.00);


INSERT INTO tb_tipos_quarto (nome, valor_diaria)
VALUES
('Standard', 180.00),
('Luxo', 320.50),
('Executivo', 250.75),
('Presidencial', 580.90);


INSERT INTO tb_quartos (numero, andar, descricao, tipo_quarto_id)
VALUES
(101, 1, 'Quarto com vista para o mar', 1),
(202, 2, 'Quarto standard com varanda', 2),
(303, 3, 'Suite executiva com escritorio', 3),
(404, 4, 'Suite presidencial com jacuzzi', 4);

INSERT INTO tb_clientes (cpf, nome, telefone, cidade_origem)
VALUES
('12345678901234', 'Ana Souza', '(11) 91234-5678', 'Sao Paulo'),
('23456789012345', 'Carlos Lima', '(21) 99876-5432', 'Rio de Janeiro'),
('34567890123456', 'Fernanda Alves', '(31) 98765-4321', 'Belo Horizonte'),
('45678901234567', 'Joao Pereira', '(41) 97654-3210', 'Curitiba');


INSERT INTO tb_reservas (
    data_reserva,
    data_inicio,
    quantidade_dias,
    cliente_id,
    quarto_id,
    status
)
VALUES
('2025-11-20', '2025-11-22', 3, 1, 1, 'ATIVA'),
('2025-11-21', '2025-11-23', 2, 2, 2, 'CANCELADA'),
('2025-11-22', '2025-11-24', 4, 3, 3, 'ATIVA'),
('2025-11-23', '2025-11-25', 1, 4, 4, 'ATIVA');

INSERT INTO tb_estadias (
    data_check_in,
    data_check_out,
    valor_total,
    cliente_id,
    quarto_id
)
VALUES
-- Cliente 1 no quarto Standard (R$180/dia, 3 dias)
('2025-11-20 14:00', '2025-11-23 12:00', 540.00, 1, 1),

-- Cliente 2 no quarto Luxo (R$320,50/dia, 2 dias)
('2025-11-21 15:00', '2025-11-23 11:00', 641.00, 2, 2),

-- Cliente 3 na Suite Executiva (R$250,75/dia, 4 dias)
('2025-11-22 13:00', '2025-11-26 12:00', 1003.00, 3, 3),

-- Cliente 4 na Suite Presidencial (R$580,90/dia, 1 dia)
('2025-11-23 16:00', '2025-11-24 11:00', 580.90, 4, 4);


INSERT INTO tb_servicos_solicitados (quantidade, valor_total, estadia_id, servico_id)
VALUES
-- Estadia 1 (Cliente 1) pediu 2 cafes da manha (R$50 cada)
(2, 100.00, 1, 1),

-- Estadia 2 (Cliente 2) pediu 1 lavanderia (R$80)
(1, 80.00, 2, 2),

-- Estadia 3 (Cliente 3) pediu 3 sessoes de spa (R$200 cada)
(3, 600.00, 3, 3),

-- Estadia 4 (Cliente 4) pediu 1 translado (R$150)
(1, 150.00, 4, 4);



