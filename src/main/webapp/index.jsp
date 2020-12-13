<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Document</title>
    <style>
      body {
        font-family: Lato, sans-serif;
        margin: auto;
        width: 800px;
      }

      h1 {
        margin: 10px 0;
      }
      p{
          margin: 5px 0;
      }
      form {
        width: 400px;
        margin: auto;
        display: flex;
        flex-direction: column;
        justify-content: center;
        text-align: center;
        margin: 20px auto;
      }
      input {
        outline: 0;
        padding: 10px 20px;
        box-sizing: border-box;
        border-radius: 10px;
        margin: 5px;
        border: 2px solid #1D2A31;
        background-color: #E5E5E5;
      }

      button {
        border: none;
        outline: 0;
        padding: 10px 20px;
        border-radius: 10px;
        color: #1D2A31;
        background-color: #52B792;
        margin: 5px;
      }
      .radio-choice {
        display: flex;
        flex-direction: row;
        align-items: center;
      }
      .radio__wrapper {
        display: flex;
        flex-direction: row;
        margin: auto;
        margin-bottom: 10px;
      }
    </style>
</head>
<body>
<form action="">
   <p>Chose a parser:</p>
   <div class="radio__wrapper">
     <div class="radio-choice">
        <input type="radio" name="parser" value="sax" id="sax">
        <label for="sax">SAX</label>
     </div>
     <div class="radio-choice">
        <input type="radio" name="parser" value="dom" id="dom">
        <label for="dom">DOM</label>
     </div>
     </div>
     <label>File name: </label>
     <input type="text" name="fileName" value="hospital">
     <button>Parse</button>
</form>
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
</body>
</html>