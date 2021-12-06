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

        table tr {
            height: 40px;

        }

        input {
            margin: 0px 14px;
            padding: 0px;
            width: 160px;
            height: 30px;
            outline: none;
            box-sizing: border-box;
        }

        button {
            margin: 20px 0px 0px 300px;
            width: 60px;
            height: 40px;
        }

        .pub {
            margin: 0px 0px 0px 0px;
            width: 30px;
            height: 20px;
        }
        .q {
            padding: 0px 14px;
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
            <table>
                <tbody>
                    <tr>
                        <td>罚单ID:</td>
                        <td><input type="text" id="id"></td>
                        <td>违章日期:</td>
                        <td><input type="text" id="edate"></td>
                    </tr>
                    <tr>
                        <td>开罚单的日期:</td>
                        <td><input type="text" name="" id="pdate"></td>
                        <td>违章地点:</td>
                        <td><input type="text" id="place"></td>
                    </tr>
                    <tr>
                        <td>违章记载:</td>
                        <td><input type="text" id="record"></td>
                        <td>驾驶人ID:</td>
                        <td><input type="text" id="did"></td>
                    </tr>
                    <tr>
                        <td>处罚:</td>
                        
                        <td class="q">
                            警告
                            <input type="radio" name="pub1" class="pub"  value="1">是
                            <input type="radio" name="pub1" class="pub"  value="0">否
                        </td>
                        <td class="q">
                            罚款
                            <input type="radio" name="pub2" class="pub" value="1">是
                            <input type="radio" name="pub2" class="pub" value="0">否
                        </td>
                        <td class="q">
                            暂扣驾驶执照
                            <input type="radio" name="pub3" class="pub" value="1">是
                            <input type="radio" name="pub3" class="pub" value="0">否
                        </td>

                    </tr>
                    <tr>
                        <td>汽车ID:</td>
                        <td><input type="text" id="cid"></td>
                        <td>警员ID:</td>
                        <td><input type="text" id="pid"></td>
                    </tr>
                   
                </tbody>
            </table>
            <button id="sub">提交</button>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $('#sub').click(function () {
                $.ajax({
                    url: '${pageContext.request.contextPath}/ticket/add',
                    data: {
                        'T_no': $('#id').val(),
                        'T_date': $('#edate').val(),
                        'T_time': $('#pdate').val(),
                        'T_location': $('#place').val(),
                        'T_record': $('#record').val(),
                        'D_no': $('#did').val(),
                        'T_punishment_warning': $('input[name="pub1"]:checked').val(),
                        'T_punishment_fine': $('input[name="pub2"]:checked').val(),
                        'T_punishment_deduction': $('input[name="pub3"]:checked').val(),
                        'C_no': $('#cid').val(),
                        'P_no': $('#pid').val()
                    },
                    success: function (data) {
                        // console.log(data);
                    }
                })
            })
        })
    </script>
</body>

</html>