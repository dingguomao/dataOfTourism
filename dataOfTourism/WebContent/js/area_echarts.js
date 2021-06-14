

$(function () {
  map();
    
    function map() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('map_1'));
        var data=[];
    	$.ajax({
    		url:"./queryServlet",
    		dataType:"json",
    		async:false,
    		success:function(result){
//    			console.log(result);
    		  for(i=0;i<result.length;i++){
    			  var lo = result[i].longitude;
    			  var la = result[i].latitude;
    			  
    			  var data0 = {};
    			  data0['name']=result[i].name;
    			  data0['prvince']=result[i].prvince;
    			  data0['jianjie']=result[i].introduce;
    			  data0['value'] = lo+','+la;
    			  data.push(data0);
    			  
    		  }
    		}
    	});
        
 var convertData = function (data) {

    var res = [];
    var jj={};
    for (var i = 0; i < data.length; i++) {
//    	console.log(data[i].jianjie);
    	var jingwei = (data[i].value.split(",")).map(Number);
//    	console.log(jingwei[1]);
    	
        var geoCoord = data[i].value;

        if (geoCoord) {
            res.push({
                name: data[i].name,
                prvince:data[i].prvince,
                jianjie:data[i].jianjie,
                value: jingwei.concat(150)
            });
//            console.log(geoCoord);
        }
    }
    console.log(res);
    return res;
};

option = {
  

    geo: {
        map: 'china',
        label: {
            emphasis: {
                show: true
            }
        },
        roam: true,//放大缩小
        itemStyle: {
            normal: {
                areaColor: '#4c60ff',
                borderColor: '#002097'
            },
            emphasis: {
                areaColor: '#293fff'
            }
        }
    },
    series : [
        {
            name: '消费金额',
            type: 'scatter',
            coordinateSystem: 'geo',
            data: convertData(data),
            symbolSize: function (val) {
                return val[2] / 15;
            },
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: false
                },
                emphasis: {
                    show: true
                }
            },
            itemStyle: {
                normal: {
                    color: '#ffeb7b'
                }
            }
        }
		
	
    ]
};
		
        myChart.setOption(option);
        myChart.on('click',function(params){
        	console.log(params['data'].prvince);
            var name = params.name;
            var jianjie=params['data'].jianjie;
            var prvince=params['data'].prvince;
            var value = params.value;
            console.log(params);
//            console.log(name+"\n"+value);
            var weather = document.getElementById("tianqi");
            var tianqi = '<iframe scrolling="no" src="https://tianqiapi.com/api.php?style=ya&city='+prvince+'&skin=sogou&color=bbffaa&paddingtop=50&fontsize=18" frameborder="0" width="320" height="250" allowtransparency="true"></iframe>'
            weather.innerHTML = tianqi;
            var abstract = document.getElementById("abstract");
            var x ='<h2>景区简介</h2> <br/> <a>景区：'+name+' <br/> '+jianjie+'</a>';
            abstract.innerHTML=x;
        
        })
        
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }

})



