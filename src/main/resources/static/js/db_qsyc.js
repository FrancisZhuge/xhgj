$(function () {
    /*企业能耗的点击事件*/
    var data_consition = [0, 0, 0, 0, 0, 0, 0];
    var myChart = echarts.init(document.getElementById('qsyc'));
    option = {
        title: {
            text: '折线图堆叠'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            top: 30,
            data: []
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            top: 80,
            containLabel: true
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        yAxis: {
            type: 'value',

            axisLabel: {
                formatter: '{value} 千瓦时'
            }
        },
        series: [
            {
                name: '',
                type: 'line',
                data: [0, 0, 0, 0, 0, 0, 0]
            }
        ]
    };
    myChart.setOption(option);

    $.ajax({
        type: 'POST',
        dataType: 'json',
        async: true,
        url:  'xhgj/power/tswk_consume?companyId=1',
        success: function (myJson) {
            if (JSON.stringify(myJson) == '[]') {
                console.log("用电状态趋势json请求成功，但该公司暂无数据！");
                return 0;
            }
            //装入数据
            for (var i in myJson.data) {
                data_consition[myJson.data[i].id - 1] = myJson.data[i].value;
            }
            console.log("用电状态：");
            for (var i = 0; i < 7; i++) {
                console.log(data_consition[i]);
            }
            //表格重新绘制
            myChart.setOption({
                legend: {
                    top: 30,
                    data: [$("#qsComName option:selected").html()]
                },
                series: [
                    {
                        name: $("#qsComName option:selected").html(),
                        data: data_consition
                    }
                ]
            });
        },
        error: function () {
            console.log("用电状态及趋势json信息请求失败");
        }
    });
    $("#click_qs").click(function () {
        data_consition = [0, 0, 0, 0, 0, 0, 0];
        var companyId = $("#qsComName").val();
        var setUrl ='xhgj/power/tswk_consume?companyId='+companyId;
        $.ajax({
            type: 'POST',
            dataType: 'json',
            async: true,
            url: setUrl,
            success: function (myJson) {
                if (JSON.stringify(myJson) == '[]') {
                    console.log("用电状态趋势json请求成功，但该公司暂无数据！");
                    return 0;
                }
                //装入数据
                for (var i in myJson.data) {
                    data_consition[myJson.data[i].id - 1] = myJson.data[i].value;
                }
                console.log("用电状态：");
                for (var i = 0; i < 7; i++) {
                    console.log(data_consition[i]);
                }
                //表格重新绘制
                myChart.setOption({
                    legend: {
                        top: 30,
                        data: [$("#qsComName option:selected").html()]
                    },
                    series: [
                        {
                            name: $("#qsComName option:selected").html(),
                            data: data_consition
                        }
                    ]
                });
            },
            error: function () {
                console.log("用电状态及趋势json信息请求失败");
            }
        });
    });
});
<!--日历使用的函数-->
function showChartZZT() {
    var queryHY = document.getElementById("queryHY").value; //行业
    var queryQY = document.getElementById("queryQY").value; //企业名称
    var queryTime_1 = document.getElementById("startdate").value;  //开始日期
    var queryTime_2 = document.getElementById("enddate").value;    //结束日期
    alert('提交数据为：' + "行业=" + queryHY + "； 企业=" + queryQY + "； 开始时间=" + queryTime_1 + "； 结束时间=" + queryTime_2);
}

// 开始时间不能晚于结束时间
var modal = (function () {
    var initDate = function (startDateTimeId, endDateTimeId) {
        var startDate;
        var endDate;
        startDateTimeId = "#" + startDateTimeId;
        endDateTimeId = "#" + endDateTimeId;
        $(startDateTimeId).datetimepicker({
            format: 'Y-m-d',
            minDate: false,
            onChangeDateTime: function (dp, $input) {
                startDate = $(startDateTimeId).val();
            },
            onClose: function (current_time, $input) {
                if (startDate > endDate) {
                    $(startDateTimeId).val(endDate);
                    startDate = endDate;
                }
            }
        });
        $(endDateTimeId).datetimepicker({
            format: 'Y-m-d',
            onClose: function (current_time, $input) {
                endDate = $(endDateTimeId).val();
                if (startDate > endDate) {
                    $(endDateTimeId).val(startDate);
                    endDate = startDate;
                }
            }
        });
    };
    return {
        initDate: initDate
    };
})();
modal.initDate("startdate", "enddate");
//只需要日期选择,disable时间选择器
$("#startdate").datetimepicker({format: 'Y-m-d', timepicker: false});
$("#enddate").datetimepicker({format: 'Y-m-d', timepicker: false});