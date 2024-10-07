/**
 * 
 */
function getParam() {
    const formObjs = document.querySelectorAll('input');
    const param = new FormData();

    for (const formObj of formObjs) {
        param.append(formObj.id, formObj.value);
    }

    return param;
}

function goPage(url){
	location.href = url;
}

function ajax(conf){
	conf.method = conf.method?conf.method:'GET';
	const xhr = new XMLHttpRequest();
	let param = '';
	if(conf.param){
		if(conf.method!=='GET'){
			param = conf.param;
		}else{
			conf.url = conf.url + '?' + conf.param;
		}
	}
	xhr.open(conf.method, conf.url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === xhr.DONE){
			if(xhr.status === 200){
				conf.callback(xhr.responseText);
			}
		}
	}
	if(conf.json){
		xhr.setRequestHeader('Content-Type','application/json');
	}
	xhr.send(param);
}