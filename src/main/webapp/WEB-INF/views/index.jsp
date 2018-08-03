<!DOCTYPE html>
<html lang="en">

<head>
<title>Keep-Board</title>
</head>

<body>
	<!-- Create a form which will have text boxes for Note title, content and status along with a Add 
		 button. Handle errors like empty fields -->
	<h1>Enter Note Details:</h1>
	<br>

	<form action="saveNote" method="POST" id="form">

		<label for="">Note Id: </label> <input type="text" name="noteId"
			id="noteId" /><br> <label for="">Note Title: </label> <input
			type="text" name="noteTitle" id="noteTitle" /><br> <label
			for="">Note Content: </label>
		<textarea name="noteContent" rows="8" cols="20" id="noteContent"></textarea>
		<br> <label for="">Note Status: </label> <input type="text"
			name="noteStatus" id="noteStatus" /><br> <input type="submit"
			value="Save Note" />

	</form>


	<!-- display all existing notes in a tabular structure with Title,Content,Status, Created Date and Action -->
	<table>
		<tr>
			<th>Note Id</th>
			<th>Note Title</th>
			<th>Note Content</th>
			<th>Note Status</th>
			<th>Note Created At</th>
			<th>Note Action</th>
		</tr>

		<%-- 		<c:forEach items="${note}" var="note">
			<tr>
				<th><c:out value="${note.noteId}"/></th>
				<th><c:out value="${note.noteTitle}"/></th>
				<th><c:out value="${note.noteContent}"/></th>
				<th><c:out value="${note.getNoteStatus}"/></th>
				<th><c:out value="${note.getNoteCreatedAt}"/></th>
				<th><input type="button" value="Delete"></th>
			</tr>
		</c:forEach>	 --%>


	</table>
</body>

</html>