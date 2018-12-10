<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<html>
<head>
<title>Exame CRUD</title>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<s:a action="ExamePreparaCadastro">Novo Exame</s:a><br>
	<s:a action="ExameLista">Listar exames</s:a>

	<hr>

	<c:if test="${not empty exames}">
		<h1>Exames</h1>
		<s:form theme="bootstrap">
			<table class="table table-striped">
				<tr>
					<th>Nome do Paciente</th>
					<th>Tipo de Exame</th>
					<th>Médico</th>
					<th>Data do Exame</th>
					<th>Alterar</th>
					<th>Remover</th>
				</tr>

				<s:iterator value="exames" status="status">
					<tr>
						<td><s:property value="nomePaciente" /></td>
						<td><s:property value="tipoExame.nome" /></td>
						<td><s:property value="medico.nome" /></td>
						<td><s:property value="dataExame" /></td>
						<td><s:a action="ExamePreparaAlteracao">
							alterar
							<s:param name="exame.id" value="id" />
							</s:a></td>
						<td><s:a action="ExameRemove">
							remove
							<s:param name="exame.id" value="id" />
							</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</s:form>
	</c:if>
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