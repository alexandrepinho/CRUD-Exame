<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Exame CRUD</title>
</head>
<body>
	<s:a href="index.jsp">Home</s:a>
	<br>
	<s:a action="ExamePreparaCadastro">Novo Exame</s:a>
	<hr>

	<c:if test="${not empty exames}">
		<h1>Exames</h1>
		<table>
			<tr>
				<th>Nome do Paciente</th>
				<th>Tipo de Exame</th>
				<th>Médico</th>
				<th>Data do Exame</th>
				<th>Alterar</th>
				<th>Remover</th>
			</tr>

			<s:iterator value="exames" status="status">
				<tr style="background-color: ${status.even ? '#EEEEEE' : '#FFFFFF'}">
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
	</c:if>
</body>
</html>