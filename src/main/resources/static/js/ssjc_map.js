$(document).ready(function() {

    var data = {
        'A22': { 'companyName': '浙江久厨节能科技有限公司', 'factoryNumber': 'A11', 'electricity': 134.87, 'water': 26.14, 'energyState': '正常' }, //能耗状态：正常
        'A18': { 'companyName': '湖州三荣节能环保产品贸易有限公司', 'factoryNumber': 'A18', 'electricity': 10, 'water': 10, 'energyState': '正常' },
        'A19': { 'companyName': '浙江国鼎环境工程有限公司', 'factoryNumber': 'A19', 'electricity': 20, 'water': 5, 'energyState': '正常' },
        'A17': { 'companyName': '浙江德赛堡建筑材料科技有限公司', 'factoryNumber': 'A17', 'electricity': 40, 'water': 7, 'energyState': '正常' }
    };
    // drawFactor(divId, imgId, data, max)
    // 父级容器的div
    // data: 传入的数据
    // max: 用电量的最大值
    var url = 'css/img/map/huzhou_3d.jpeg';
    drawFactory('container', data, 10000, url)
});