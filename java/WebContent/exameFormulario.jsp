<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Exame CRUD</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/jquery-ui.css">

</head>
<body>
	<s:a href="index.jsp">Home</s:a>
	<hr />

	<h1>Cadastro ou Alteração de Exames</h1>
	<s:form action="ExameAdicionaOuAltera">
		<s:hidden name="exame.id" />
		<s:textfield label="Paciente " name="exame.nomePaciente" />
		<s:textfield label="Documento Paciente "
			name="exame.documentoPaciente" />

		<s:select name="tipoExameSelecionado" list="tiposExame" listKey="id"
			listValue="nome" headerKey="" headerValue="Selecione" label="Tipo" />

		<s:radio label="Finalidade" name="finalidadeSelecionada"
			list="finalidades" value="exame.finalidade" />

		<s:select name="medicoSelecionado" list="medicos" listKey="id"
			listValue="nome" headerKey="" headerValue="Selecione" label="Médico" />

		<s:textfield label="Data do exame" id="datepicker" name="dataExame" />
		<s:textfield label="Data do vencimento" id="datepicker2"
			name="dataVencimento" />


		<s:submit value="Salvar" />
	</s:form>
	<script src="./js/jquery-1.12.4.js"></script>
	<script src="./js/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker").datepicker();
			$("#datepicker").datepicker("option", "dateFormat", "dd/mm/yy");
		});
		$(function() {
			$("#datepicker2").datepicker();
			$("#datepicker2").datepicker("option", "dateFormat", "dd/mm/yy");

		});
	</script>
</body>
</html>