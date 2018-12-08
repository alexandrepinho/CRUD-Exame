<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Exame CRUD</title>
</head>
<body>
	<s:a href="index.jsp">Home</s:a>
	<hr/>
	
	<h1>Cadastro ou Alteração de Exames</h1>
	<s:form action="ExameAdicionaOuAltera">
		<s:hidden name="exame.id"/>
		<s:textfield label="Tipo: " name="exame.tipoExame.id" />
		<s:textfield label="Médico: " name="exame.medico.id" />
		<s:submit value="Salvar" />
	</s:form>
</body>
</html>