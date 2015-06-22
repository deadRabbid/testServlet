<%@ page import="com.shevtcov.web.UserBeans" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.shevtcov.objects.User" %>
<%@ page import="com.shevtcov.objects.Operation" %>
<%--
  Created by IntelliJ IDEA.
  User: deadRabbit
  Date: 18.06.2015
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>UserServlet</title>
  </head>
  <body>
  <%
    UserBeans users;
    if(request.getAttribute("model") !=null){
      users = (UserBeans)request.getAttribute("model");
    } else {
      Operation op = new Operation();
      users = new UserBeans();
      users.setList(op.getAll());
    }
  %>

  <form action="userservlet" method="get">
    <table border="1" width="30%">
      <tr>
      <td>Login</td>
      <td><input type="text" name="login"></td>>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="text" name="password"></td>>
      </tr>
      <tr>
        <td>Age</td>
        <td><input type="text" name="age"></td>>
      </tr>
      <tr>
      <tr>
        <td>Name</td>
        <td><input type="text" name="name"></td>>
      </tr>

        <td colspan="2"><input type="submit" name="Save"></td>>
      </tr>
    </table>
  </form>
  <table border="1" width="60&">
    <tr>
      <th>ID</th>
      <th>Login</th>
      <th>Password</th>
      <th>Age</th>
      <th>Name</th>
      <th>Option</th>
    </tr>
    <%
      Iterator<User> list = users.getList().iterator();
      while (list.hasNext()){
        User u = list.next();
      %>
    <tr>
      <form action="userservlet" method="get">
      <td><%=u.getId() %> </td>
      <td><input type="text" name="edit_login" value="<%=u.getLogin() %>"> </td>
      <td><input type="text" name="edit_pass" value="<%=u.getPassword() %>"> </td>
      <td><input type="text" name="edit_age" value="<%=u.getAge() %>"> </td>
      <td><input type="text" name="edit_name" value="<%=u.getName() %>"> </td>
      <td>
          <input type="hidden" name="edit_id" value="<%=u.getId() %>">
          <input type="hidden" name="action" value="edit">
          <input type="submit" value="edit">
      </form>

      <form action="userservlet" method="get">
      <input type="hidden" name="id" value="<%=u.getId() %>">
      <input type="hidden" name="action" value="delete">
      <input type="submit" value="delete">
      </form>
      </td>
    </tr>
    <%  } %>


  </table>
  </body>
</html>
