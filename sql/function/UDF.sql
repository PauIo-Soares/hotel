USE db_hotel
GO

CREATE FUNCTION fn_listaQuartos(@data DATE)
RETURNS @tabela TABLE (
andar		int,
numero		int,
descricao		varchar(255),
status_reserva		varchar(255)
)
AS
BEGIN
	DECLARE @id		int,
			@andar		int,
			@numero		int,
			@descricao		varchar(255)

	DECLARE c CURSOR
		for Select id, andar, numero, descricao
			from tb_quartos
	OPEN c
	FETCH NEXT FROM c
		INTO @id, @andar, @numero, @descricao
	WHILE @@FETCH_STATUS = 0
	BEGIN
		IF EXISTS(
			SELECT 1
			FROM tb_reservas
			WHERE quarto_id = @id
			AND @data BETWEEN data_inicio AND DATEADD(DAY, quantidade_dias - 1, data_inicio)
			AND status = 'CANCELADA'
		)
		BEGIN
			INSERT INTO @tabela (andar, numero, descricao, status_reserva)
			VALUES (@andar, @numero, @descricao, 'Disponivel')
		END
		ELSE IF NOT EXISTS(
			SELECT 1
			FROM tb_reservas
			WHERE quarto_id = @id
		)
		BEGIN
			INSERT INTO @tabela (andar, numero, descricao, status_reserva)
			VALUES (@andar, @numero, @descricao, 'Disponivel')
		END

		FETCH NEXT FROM c
			into @id, @andar, @numero, @descricao
	END
	CLOSE c
	DEALLOCATE c

	RETURN
END
GO

