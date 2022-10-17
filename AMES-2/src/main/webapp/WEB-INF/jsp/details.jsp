<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 

<h1  align="center">Resource Performance Report - In MFRP</h1>
<hr>

<a href="/exportpdf">Export PDF</a>
 
<table border="1" align="center">
	<tr>
	<h2 align="center">Resource Performance Report - In MFRP</h2>
		<th>batchCode</th>
		<th>associateId</th>
	 	<th>associateName</th>
	 	<th>assessorMark</th>
	 	<th>mentorMark</th>
	 	<th>assessorRemarks</th>
	 	<th>mentorRemarks</th>
	</tr>
	<c:forEach items="${details}" var="associate">
		<tr>
			<td>${associate.batchCode}</td>
			<td>${associate.associateId}</td>
		 <td>${associate.associateName}</td>
			<td>${associate.assessorMark}</td>
			<td>${associate.mentorMark}</td>
			<td>${associate.assessorRemarks}</td>
			<td>${associate.mentorRemarks}</td>
		 
		</tr>
	</c:forEach>
</table>