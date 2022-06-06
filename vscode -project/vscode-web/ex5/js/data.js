$.get("data/data.json","",function(data)
{
    $.each(data,function(i,item){
        if(item.user=="huang")
            console.log(item.msg);

    });
})