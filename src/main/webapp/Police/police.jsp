<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>警察</title>
    <script type="text/javascript" src='${pageContext.request.contextPath}/statics/jquery-1.11.3.js'></script>
    <style>
        * {
            padding: 0;
            margin: 0;
        }
        a {
            text-decoration: none;
            color: #000;
        }
        .head {
            margin-bottom: 30px;
            width: 100%;
            height: 100px;
            line-height: 100px;
            background-color: #3690ea;
        }

        .t1 {
            float: left;
            margin-left: 20px;
            font-size: 34px;
            font-weight: 700;
        }

        .t2 {
            float: right;
            margin-right: 20px;
            font-size: 20px;
        }

        /* .body {
            /* background-color: pink; */

        /* } */ 

        .left {
            margin: 0px 20px 0px 20px;
            width: 180px;
            /* background-color: ; */
        }

        .left div {
            margin: 0px 0px 20px 0px;
            padding: 10px;
            width: 160px;
            height: 40px;
            font-size: 20px;
            text-align: center;
            line-height: 40px;
            background-color: #D6D6D6;
        }
    </style>
</head>

<body>
    <div class="head">
        <span class="t1">交通违章管理平台</span>
        <span class="t2">
            <a href="../index.jsp">退出</a>
        </span>
    </div>
    <div class="body">
        <div class="left">
            <a href="p1.jsp">
                <div>罚单信息查询</div>
            </a>
            <a href="p2.jsp">
                <div>罚单信息修改</div>
            </a>
            <a href="p3.jsp">
                <div>罚单信息添加</div>
            </a>
            <a href="p4.jsp">
                <div>警察信息查询</div>
            </a>
            <a href="p5.jsp">
                <div>警察信息修改</div>
            </a>
            
        </div>
        <div class="right"></div>
    </div>
    <script>
        $(document).ready(function() {

        })
    </script>
</body>

</html>