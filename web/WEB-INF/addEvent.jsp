<%--
  Created by IntelliJ IDEA.
  User: Paruyr
  Date: 02.09.2022
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Event</title>
</head>
<body>
<h1> Please input event data</h1> <br>
<form action="/events/add" method="post">
    <input type="text" name="name" placeholder="Please input name"> <br>
    <input type="text" name="place" placeholder="Please input place"> <br>
    <input type="number" name="price" placeholder="Please input price"> <br>
    Is Online? <br>
    YES <input type="radio" name="isOnline" value="TRUE">
    NO <input type="radio" name="isOnline" value="FALSE">
    <br>
    Event type <br>
    <select name="eventType">
        <option value="MEETING"> MEETING </option>
        <option value="DANCE"> DANCE </option>
        <option value="SEMINAR"> SEMINAR </option>
        <option value="FESTIVAL"> FESTIVAL </option>
        <option value="OTHER"> OTHER </option>
    </select>
    <br>
    <input type="date" name="eventDate"> <br>
    <input type="submit" name="Add">


</form>


</body>
</html>
