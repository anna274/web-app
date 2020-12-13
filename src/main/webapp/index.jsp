<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Document</title>
</head>
<body style="margin-right: 20%; margin-left: 20%; text-align: center">
<div style="padding: 3%">
    <form action="">
        <p>Chose a parser:&nbsp;
            <input type="radio" name="parser" value="sax">&nbsp;SAX;&nbsp;
            <input type="radio" name="parser" value="dom">&nbsp;DOM;&nbsp;
        </p>
        <label>File name: </label>
        <input type="text" name="fileName" value="hospital">
        <button>Parse</button>
    </form>
</div>
<div style="padding: 3%">
    <div style="padding: 3%">
        <table border=1 width=100% cellpadding=5>
            <thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Diagnosis</th>
                <th>Insurance number</th>
                <th>Covid status</th>
            </tr>
            </thead>

            <tbody>
            <c:if test="${patients != null}">
                <c:forEach var="patient" items="${patients}">
                    <tr>
                        <td>${patient.name}</td>
                        <td>${patient.age}</td>
                        <td>${patient.diagnosis}</td>
                        <td>${patient.insuranceNumber}</td>
                        <td>${patient.covidStatus}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>