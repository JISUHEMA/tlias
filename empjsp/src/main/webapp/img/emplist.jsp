<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css"/>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br/>
                    <a href="javascript:;" @click="logout">安全退出</a>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="/ems_vue/emplist.html">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome {{ user.realname }}!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        名前
                    </td>
                    <td>
                        誕生日
                    </td>
                    <td>
                        月給
                    </td>
                    <td>
                        性別
                    </td>
                    <td>
                        操作
                    </td>
                </tr>
                <c:forEach items="${requestScope.employee}" var="employee" varStatus="sta">
                <tr
                	<c:if test="${sta.index%2==0 }">
                		class="row1"
                	</c:if>
                	<c:if test="${sta.index%2==1 }">
                		class="row2"
                	</c:if>                 
                 >
                 
                    <td>
                        ${employee.id}
                    </td>
                    <td>
                        ${employee.name}
                    </td>
                    <td>
                        ${employee.birthday}
                    </td>
                    <td>
                        ${employee.salary}
                    </td>
                    <td>
                        ${employee.gender}
                    </td>
                    <td>
                        <a href="javascript:;" onclick="deleteEmployee(${employee.id})">削除</a>
                        <script>
	                        function deleteEmployee(id){
		                        debugger
								if(window.confirm("このレコードは削除していいですか？")){
	            			 location.href='${pageContext.request.contextPath}/employee/delete?id='+id
								}
	                        }
                        </script>                        
                        
                        &nbsp;<a href="'/ems_vue/updateEmp.html?id='+emp.id">
                        更新</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <p>
                <input type="button" class="button" value="社員を追加する" onclick="location='${pageContext.request.contextPath}/addEmp.jsp'"/>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
