$(function () {
    mChart1 = echarts.init(document.getElementById('ele'));
    mChart1.showLoading();
    mChart1.title = '某站点用户访问来源';
    var data_tip = [0, 0, 0, 0, 0, 0, 0];  //尖能耗
    var data_peak = [0, 0, 0, 0, 0, 0, 0];  //峰能耗
    var data_valley = [0, 0, 0, 0, 0, 0, 0]; //谷能耗
    var data_total = [0, 0, 0, 0, 0, 0, 0];  //总能耗
    option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data: ['尖能耗', '峰能耗', '谷能耗', '总能耗']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'value'
        },
        yAxis: {
            type: 'category',
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        series: [
            {
                name: '尖能耗',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: data_tip
            },
            {
                name: '峰能耗',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: data_peak
            },
            {
                name: '谷能耗',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: data_valley
            },
            {
                name: '总能耗',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: data_total
            }

        ]
    };
    mChart1.hideLoading();
    mChart1.setOption(option);

    click_qynh = false;
    $("#qynh").click(function () {
        if (!click_qynh) {
            $.ajax({
                type: 'POST',
                dataType: 'json',
                async: true,
                url: '/xhgj/power/tswk_jfg_consume?companyId=1',
                success: function (myJson) {
                    //装入数据
                    for (var index in myJson.data) {
                        data_tip[myJson.data[index].id - 1] = myJson.data[index].jianValue;
                        data_peak[myJson.data[index].id - 1] = myJson.data[index].fengValue;
                        data_valley[myJson.data[index].id - 1] = myJson.data[index].guValue;
                        data_total[myJson.data[index].id - 1] = myJson.data[index].zongValue;
                    }
                    console.log("尖能耗：" + data_tip);
                    console.log("峰能耗：" + data_peak);
                    console.log("谷能耗：" + data_valley);
                    console.log("总能耗：" + data_total);
                    //表格重新绘制
                    mChart1.hideLoading();
                    mChart1.setOption({
                        series: [
                            {
                                name: '尖能耗',
                                data: data_tip
                            },
                            {
                                name: '峰能耗',
                                data: data_peak
                            },
                            {
                                name: '谷能耗',
                                data: data_valley
                            },
                            {
                                name: '总能耗',
                                data: data_total
                            }
                        ]
                    });
                },
                error: function () {
                    console.log("企业能耗json信息请求失败");
                }
            });
            click_qynh = true;
        }
    });
    $("#clickNH").click(function () {
        data_tip = [0, 0, 0, 0, 0, 0, 0];  //尖能耗
        data_peak = [0, 0, 0, 0, 0, 0, 0];  //峰能耗
        data_valley = [0, 0, 0, 0, 0, 0, 0]; //谷能耗
        data_total = [0, 0, 0, 0, 0, 0, 0];  //总能耗
        var companyId = $("#name").val();
        var setUrl = '/xhgj/power/tswk_jfg_consume?companyId='+companyId;
        $.ajax({
            type: 'POST',
            dataType: 'json',
            async: true,
            url: setUrl,
            success: function (myJson) {
                //装入数据
                for (var index in myJson.data) {
                    data_tip[myJson.data[index].id - 1] = myJson.data[index].jianValue;
                    data_peak[myJson.data[index].id - 1] = myJson.data[index].fengValue;
                    data_valley[myJson.data[index].id - 1] = myJson.data[index].guValue;
                    data_total[myJson.data[index].id - 1] = myJson.data[index].zongValue;
                }
                console.log("尖能耗：" + data_tip);
                console.log("峰能耗：" + data_peak);
                console.log("谷能耗：" + data_valley);
                console.log("总能耗：" + data_total);
                //表格重新绘制
                mChart1.hideLoading();
                mChart1.setOption({
                    series: [
                        {
                            name: '尖能耗',
                            data: data_tip
                        },
                        {
                            name: '峰能耗',
                            data: data_peak
                        },
                        {
                            name: '谷能耗',
                            data: data_valley
                        },
                        {
                            name: '总能耗',
                            data: data_total
                        }
                    ]
                });
            },
            error: function () {
                console.log("企业能耗json信息请求失败");
            }
        });
    });
});

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

<!--对选择条件进行的-->
$(function () {
    $("#test").on("click", function () {
        $("#name").empty();//首先清空select现在有的内容
        $("#name").append("<option selected='selected'  value=0>请选择..</option>");
        for (var i = 0; i < 10; i++) {
//         var item = table[i];
            // var option = $("<option  value="+item.id+">"+item.name+"</option>");
            $("#name").append("<option  value=" + i + ">" + i + "</option>");
        }
    });
});