
/**
 * api ajax封装
 @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
 @ResponseBody
 public Result  queryAll(HttpServletResponse response){
         //后端跨域设置
         response.setHeader("Access-Control-Allow-Origin","*");
         return new Result( 200,personService.queryAll(),null ) ;
    }
 */

//测试地址
var base_test = 'http://localhost:8081/person/';
//开发地址
var base_dev = 'http://127.0.0.1:10001/person/';

var base =base_test;

//封装AJAX请求
function ajax(type, url, data, success) {
    layui.use("jquery" , function () {
        var $ = layui.jquery;
        $.ajax({
            url:base+ url,    //请求的url地址
            dataType:"json",   //返回格式为json
            async:true,//请求是否异步，默认为异步，这也是ajax重要特性
            data: data, //{"id":"value"},    //参数值
            type:type,   //请求方式
            beforeSend:function(){
                //请求前的处理
            },
            success:function(req){
                //请求成功时处理
                return success( req);
            },
            complete:function(req){
               //console.log("请求完成的处理== "+ JSON.stringify(req));
            },
            error:function(req){
                console.log( " 系统异常! 请求出错处理 【 "+ JSON.stringify(req) +" 】");
            }
        });

    });



}
/**
 * 发送post请求
 * @param {发送请求路径} url
 * @param {JSON数据} data
 * @param {发送成功回调函数} success
 */
function apiPost(url, data, success) {
    ajax('post', url, data, function (res) {
        return success(res);
    });
}

/**
 * 发送GET请求
 * @param {发送请求路径} url
 * @param {JSON数据} data
 * @param {发送成功回调函数} success
 */
function apiGet(url, data, success) {
    ajax('get', url, data, function (res) {
        return success(res);
    });
}

/**
 * 发送Delete请求
 * @param {发送请求路径} url
 * @param {JSON数据} data
 * @param {发送成功回调函数} success
 */
function apiDelete(url, data, success) {
    ajax('delete', url, data, function (res) {
        return success(res);
    });
}

/**
 * window.location.href
 * @param url
 */
function apiLocation(url) {
    window.location.href= base+url;
}


/**
 * 菜单树形 工具
 id: 'resourceId',     id字段名
 parentId: 'parentId', 父id字段名
 rootId: '0'             根节点父id值
 * @param array
 * @param attr
 * @returns {Array}
 */
function arrayToTree(array, attr){
    var tree = [];
    var resData = array ;// array.concat();
    for (var i = 0; i < array.length; i++) {
        if (array[i][attr.parentId] === attr.rootId) {
            var obj = Object.assign({}, array[i]);
            tree.push(obj);
            // resData.splice(i, 1);
        }
    }
    var run = function (treeArrs) {
        if (resData.length > 0) {
            for (var i = 0; i < treeArrs.length; i++) {
                for (var j = 0; j < resData.length; j++) {
                    if (treeArrs[i][attr.id] === resData[j][attr.parentId]) {
                        var obj = Object.assign({children: []}, resData[j]);
                        if (!treeArrs[i].children) {
                            treeArrs[i].children = [];
                        }
                        treeArrs[i].children.push(obj);

                    }
                }
                if (treeArrs[i].children && treeArrs[i].children.length > 0) {
                    run(treeArrs[i].children);
                }
            }
        }
    };
    run(tree);
    return tree;
}






