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

        .right {
            padding: 20px;
        }

        .up {
            margin-bottom: 40px;
        }

        input {
            margin: 0px 14px;
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

        .down table thead tr th {
            width: 120px;
            background-color: #D6D6D6;
        }

        .down table tbody tr td {
            width: 120px;
            text-align: center;
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
            <div class="up">
                汽车ID: <input type="text" id="id">
                <button id="sub">确定</button>
            </div>
            <div class="down">
                <table>
                    <thead>
                        <tr>
                            <th>汽车ID号</th>
                            <th>机动车牌照号</th>
                            <th>型号</th>
                            <th>制造商</th>
                            <th>生产日期</th>
                            <th>驾驶人ID</th>
                        </tr>
                    </thead>
                    <tbody id="content"></tbody>
                </table>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            function formatDate(date, format) {
                if (!date) return;
                if (!format)
                    format = "yyyy-MM-dd";
                switch (typeof date) {
                    case "string":
                        date = new Date(date.replace(/-/, "/"));
                        break;
                    case "number":
                        date = new Date(date);
                        break;
                }

                if (!date instanceof Date) return;
                var dict = {
                    "yyyy" : date.getFullYear(),
                    "M" : date.getMonth() + 1,
                    "d" : date.getDate(),
                    "H" : date.getHours(),
                    "m" : date.getMinutes(),
                    "s" : date.getSeconds(),
                    "MM" : ("" + (date.getMonth() + 101)).substr(1),
                    "dd" : ("" + (date.getDate() + 100)).substr(1),
                    "HH" : ("" + (date.getHours() + 100)).substr(1),
                    "mm" : ("" + (date.getMinutes() + 100)).substr(1),
                    "ss" : ("" + (date.getSeconds() + 100)).substr(1)
                };
                return format.replace(/(yyyy|MM?|dd?|HH?|ss?|mm?)/g, function() {
                    return dict[arguments[0]];
                });
            }

            $('#sub').click(function () {
                $.ajax({
                    url: '${pageContext.request.contextPath}/driver/car/select',
                    data: {
                        'C_no': $('#id').val()
                    },
                    success: function (data) {
                        console.log('success');
                        var obj = JSON.parse(data);
                        var time = formatDate(obj.c_production_date.time,"yyyy-MM-dd");
                        var html = '';
                        html += "<tr>" + "<td>" + obj.c_no + "</td>" +
                            "<td>" + obj.c_number + "</td>" +
                            "<td>" + obj.c_model + "</td>" +
                            "<td>" + obj.c_manufacturer + "</td>" +
                            "<td>" + time + "</td>" +
                            "<td>" + obj.d_no + "</td>" + "</tr>"
                        $('#content').html(html);
                    }
                })
            })
        })
    </script>
</body>

</html>