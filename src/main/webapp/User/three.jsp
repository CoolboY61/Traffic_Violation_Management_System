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
        <div class="left">
            <a href="one.jsp">
                <div>汽车信息查询</div>
            </a>
            <a href="two.jsp">
                <div>汽车信息修改</div>
            </a>
            <a href="three.jsp">
                <div>汽车信息添加</div>
            </a>
            <a href="four.jsp">
                <div>罚单信息查询</div>
            </a>
            <a href="five.jsp">
                <div>用户信息查询</div>
            </a>
            <a href="six.jsp">
                <div>用户信息修改</div>
            </a>
        </div>
        <div class="right">
            <table>
                <tbody>
                    <tr>
                        <td>汽车ID号:</td>
                        <td><input type="text" id="1"></td>
                    </tr>
                    <tr>
                        <td>机动车牌照号:</td>
                        <td><input type="text" id="2"></td>
                    </tr>
                    <tr>
                        <td>型号:</td>
                        <td><input type="text" id="3"></td>
                    </tr>
                    <tr>
                        <td>制造商:</td>
                        <td><input type="text" id="4"></td>
                    </tr>
                    <tr>
                        <td>生产日期:</td>
                        <td><input type="text" id="5"></td>
                    </tr>
                    <tr>
                        <td>驾驶人ID:</td>
                        <td><input type="text" id="6"></td>
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
                    url: '${pageContext.request.contextPath}/driver/car/add',
                    data: {
                        'C_no': $('#1').val(),
                        'C_number': $('#2').val(),
                        'C_model': $('#3').val(),
                        'C_manufacturer': $('#4').val(),
                        'C_production_date': $('#5').val(),
                        'D_no': $('#6').val()
                    },
                    success:function(data) {
                        console.log('success');
                    }
                })
            })
        })
    </script>
</body>

</html>