<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Customer list</h2>
	<div class="glis">
	<form action="glis" method="post" name="glis">
	 <table>
            <tr>
                <td>
                    <table class="list" id="employeeList">
                        <thead>
                            <tr>
                                <th>Fullname</th>
                                <th>Street</th>
                                <th>City</th>
                                <th>Email</th>
                                <th>Last Name</th>
                                <th>Address</th>
                                <th>State</th>
                                <th>Phone</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </td>
            </tr>
        </table>
       
    </form>
        </div>
        <script>var NameValue = document.forms["glis"].value;</script>
        
</body>
</html>