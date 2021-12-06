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

        .body {
            display: flex;
            flex-direction: row;
            /* background-color: pink; */

        }

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
        <div class="right">
            <div class="up">
                罚单ID: <input type="text" id="id">
                <button id="sub">确定</button>
            </div>
            <div class="down" id="content"></div>
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
                    url: '${pageContext.request.contextPath}/ticket/select',
                    data: {
                        'T_no': $('#id').val()
                    },
                    success: function (data) {
                        var obj = JSON.parse(data);
                        console.log(obj);

                        var ctime = formatDate(obj.c_production_date.time,"yyyy-MM-dd");
                        var tdtime = formatDate(obj.t_date.time,"yyyy-MM-dd");
                        var tttime = formatDate(obj.t_time.time,"yyyy-MM-dd");
                        var html = '';
                        html += "<table align='center' border='1' cellspacing='0' cellpadding='5' width='1000' hight='250'>" +
                            "<tr>" +
                            "<th colspan='2'>交通违章通知书</th>" +
                            "</tr >" +
                            "<tbody>" +
                            "<tr>" +
                            "<td colspan='2'>编号：" + obj.t_no + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>姓名：" + obj.d_name + "</td>" +
                            "<td>驾驶证执照号：" + obj.d_license_number + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td colspan='2'>地址：" + obj.d_address + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>邮编：" + obj.d_postcode + "</td>" +
                            "<td>电话：" + obj.d_phone + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>机动车牌照号：" + obj.c_number + "</td>" +
                            "<td>型号：" + obj.c_model + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>制造商：" + obj.c_manufacturer + "</td>" +
                            "<td>生产日期：" + ctime + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>违章日期：" + tdtime + "</td>" +
                            "<td>时间：" + tttime + "</td>" +
                            "</tr >" +
                            "<tr>" +
                            "<td>地点：" + obj.t_location + "</td>" +
                            "<td>违章记载：" + obj.t_record + "</td>" +
                            "</tr >" +
                            "<tr>" +
                            "<td colspan='2'>处罚方法：" + "警告:" + obj.t_punishment_warning + "罚款:" + obj.t_punishment_fine + "暂扣驾驶执照:" + obj.t_punishment_deduction + "</td >" +
                            "</tr >" +
                            "<tr>" +
                            "<td>警察签字：" + obj.p_name + "</td>" +
                            "<td>警察编号：" + obj.p_no+ "</td>" +
                            "</tr >" +
                            "<tr>" +
                            "<td colspan='2'>被处罚人签字：" + obj.d_name + "</td>" +
                            "</tr>" +
                            "</table>";
                        $('#content').html(html);
                    }
                })
            })
        })
    </script>
</body>

</html>