<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户</title>
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

        .body {
            display: flex;
            flex-direction: row;
            /* background-color: pink; */
        }

        .left {
            margin: 0px 20px 0px 20px;
            width: 180px;
            /* background-color: skyblue; */
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

        table tbody tr td {
            padding: 14px;
        }

        input {
            padding: 0px;
            width: 160px;
            height: 40px;
            outline: none;
            box-sizing: border-box;
        }

        button {
            width: 60px;
            height: 40px;
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

    <div class="right">
        <table>
            <tbody>
            <tr>
                <td>ID号:</td>
                <td><input type="text" id="1"></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input type="text" id="2"></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><input type="text" id="3"></td>
            </tr>
            <tr>
                <td>出生日期:</td>
                <td><input type="text" id="4"></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input type="text" id="5"></td>
            </tr>
            <tr>
                <td>驾照号:</td>
                <td><input type="text" id="6"></td>
            </tr>
            <tr>
                <td>邮编:</td>
                <td><input type="text" id="7"></td>
            </tr>
            <tr>
                <td>地址:</td>
                <td><input type="text" id="8"></td>
            </tr>
            <tr>
                <td></td>
                <td><button id="sub">确定</button></td>
            </tr>
            </tbody>
        </table>



    </div>
</div>
<script>
    $(document).ready(function () {
        $('#sub').click(function() {
            $.ajax({
                url: '${pageContext.request.contextPath}/addDriver',
                data: {
                    'D_no': $('#1').val(),
                    'D_name': $('#2').val(),
                    'D_sex': $('#3').val(),
                    'D_birthday': $('#4').val(),
                    'D_phone': $('#5').val(),
                    'D_license_number': $('#6').val(),
                    'D_postcode': $('#7').val(),
                    'D_address': $('#8').val()
                },
                success:function(data) {
                    console.log('success');
                    alert("注册成功！！");
                    window.location.href = '${pageContext.request.contextPath}/index.jsp';
                }
            })
        })
    })
</script>
</body>

</html>