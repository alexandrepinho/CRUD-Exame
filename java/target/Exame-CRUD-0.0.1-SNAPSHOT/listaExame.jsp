<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Exame CRUD</title>
</head>
<body>
	<s:a href="index.jsp">Home</s:a>
	<br>
	<s:a href="exameFormulario.jsp">Novo Exame</s:a>
	<hr>
	
	<c:if test="${not empty exames}">
		<h1>Exames</h1>
		<table>
			<tr>
				<th>ID</th>
				<th>Tipo</th>
				<th>Médico</th>
				<th>Alterar</th>
				<th>Remover</th>
			</tr>
			
			<s:iterator value="exames" status="status">
				<tr style="background-color: ${status.even ? '#EEEEEE' : '#FFFFFF'}">
					<td><s:property value="id" /></td>
					<td><s:property value="tipoExame.id" /></td>
					<td><s:property value="medico.id" /></td>
					<td>
						<s:a action="ExamePreparaAlteracao">
							alterar
							<s:param name="exame.id" value="id" />
						</s:a>
					</td>
					<td>
						<s:a action="ExameRemove">
							remove
							<s:param name="exame.id" value="id" />
						</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</c:if>
</body>
</html>