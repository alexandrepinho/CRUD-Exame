<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Exame CRUD</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/bootstrap.min.css">



</head>
<body>

	<s:a action="ExameLista">Voltar</s:a>


	<h1 style="text-align: center;">Cadastro ou Alteração de Exames</h1>
	<s:form action="ExameAdicionaOuAltera" theme="bootstrap"
		cssClass="well form-search">
		<s:hidden name="exame.id" />
		<s:textfield label="Paciente " name="exame.nomePaciente"
			style="width:50%;" required="true" />

		<s:textfield label="Documento Paciente " required="true"
			style="width:50%;" name="exame.documentoPaciente" />

		<s:select name="tipoExameSelecionado" list="tiposExame" listKey="id"
			style="width:50%;" listValue="nome" headerKey=""
			headerValue="Selecione" label="Tipo" required="true" />

		<s:radio label="Finalidade" name="finalidadeSelecionada"
			list="finalidades" value="exame.finalidade" required="true" />

		<s:select name="medicoSelecionado" list="medicos" listKey="id"
			style="width:50%;" listValue="nome" headerKey=""
			headerValue="Selecione" label="Médico" required="true" />

		<s:textfield label="Data do exame" id="datepicker" name="dataExame"
			style="width:50%;" />
		<s:textfield label="Data do vencimento" id="datepicker2"
			style="width:50%;" name="dataVencimento" required="true" />

		<s:select name="apto" list="#{0:'Inapto', 1:'Apto'}"
			style="width:50%;" value="2" headerKey="-1"
			headerValue="Selecione" />


		<s:submit value="Salvar" cssClass="btn btn-primary" />
	</s:form>
	<script src="./js/jquery-1.12.4.js"></script>
	<script src="./js/jquery-ui.js"></script>
	<script src="./js/bootstrap.min.js"></script>

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