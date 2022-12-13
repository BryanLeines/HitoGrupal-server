
$('.pop-up .close').click(function(){
    $('.pop-up').removeClass('open');
});

function popUp(id){
    $('.pop-up').addClass('open');

    console.log(musicas);

    musicas.forEach(function(m){
        if(m['id'] == id){
            $('#song-url').attr('src', m['audio']);
            $('#song-url').attr('type', m['tipo']);
            $('#music-logo').attr("src",m['imagen']);
            $('#song').text(m['nombre']);
            $('#artista').text(m['autor']);
        }
    });


}


// $(function(){
//     var randomArr = [];
//     var musicMain = document.getElementById('music-div');
//     var musicList = $('#listMusic-div');
//     var audio = document.getElementById('audio-ele');
//     var song = document.getElementById('song-url');
//     var playPause = document.getElementById('play-pause');
//     var barWidth = document.getElementById('progress-bar').getClientRects()[0].width;
//     // document.onload=function(){
//     //     console.log("Ohkay")
//     //     // audio.play();
//     // }
//
//     $.get("http://5dd1894f15bbc2001448d28e.mockapi.io/playlist", function(e){
//         for(var i=0; i<e.length-1; i++){
//             musicList.append(createList(e[i].id, e[i].albumCover, e[i].track, e[i].artistaa, e[i].file))
//             randomArr.push(e[i].id)
//         }
//     });
//
//     function createList(id,url, name, artista, audios){
//         var card = $('<div>').addClass('music-cards');
//         card.id = id;
//         var img = $('<img>').addClass('card-image').attr({
//             src : url,
//             alt : name
//         })
//         card.append(img)
//
//         var desc = $('<div>').addClass('card-desc')
//         var h3 = $('<h3>').addClass('card-heading').text(name);
//         var p = $('<p>').addClass('card-author').text(artista);
//         desc.append(h3,p);
//         card.append(desc)
//
//         card.click(function(e){
//             $('#music-logo').attr({
//                 src: url,
//                 alt: name
//             })
//             $('#song').text(name);
//             $('#artista').text(artista);
//             audio.setAttribute('src',audios);
//             musicMain.className = card.id
//             $('#play-pause').get(0).className = "fas";
//             $('#play-pause').addClass("fa-pause-circle")
//             console.log(musicMain.classList[0])
//         })
//
//         return card;
//     }
//
//     playPause.onclick=function(){
//         if(audio.paused){
//             audio.play();
//             $('#play-pause').get(0).className = "fas";
//             $('#play-pause').addClass("fa-pause-circle")
//         }else {
//             audio.pause();
//             $('#play-pause').get(0).className = "fas";
//             $('#play-pause').addClass("fa-play-circle")
//         }
//     }
//
//     $('#forward').click(function(){
//         var id = Number(musicMain.classList[0])+1;
//         $.get('http://5dd1894f15bbc2001448d28e.mockapi.io/playlist/'+id,function(e){
//             $('#music-logo').attr({
//                 src: e.albumCover,
//                 alt: e.track
//             })
//             $('#song').text(e.track);
//             $('#artista').text(e.artista);
//             audio.setAttribute('src',e.file);
//             musicMain.className = e.id;
//         })
//     })
//
//     $('#backward').click(function(){
//         var id = Number(musicMain.classList[0])-1;
//         if(id === 0){
//             alert("Cant go backward")
//         }
//         else {
//             $.get('http://5dd1894f15bbc2001448d28e.mockapi.io/playlist/'+id,function(e){
//                 $('#music-logo').attr({
//                     src: e.albumCover,
//                     alt: e.track
//                 })
//                 $('#song').text(e.track);
//                 $('#artista').text(e.artista);
//                 audio.setAttribute('src',e.file);
//                 musicMain.className = e.id;
//             })
//         }
//
//     })
//
//     audio.ontimeupdate=function(){
//         $('#progress-report').css({
//             "width" : (barWidth * audio.currentTime)/audio.duration
//         })
//         if(audio.currentTime === audio.duration){
//             var id = Number(musicMain.classList[0])+1;
//             $.get('http://5dd1894f15bbc2001448d28e.mockapi.io/playlist/'+id,function(e){
//                 $('#music-logo').attr({
//                     src: e.albumCover,
//                     alt: e.track
//                 })
//                 $('#song').text(e.track);
//                 $('#artista').text(e.artista);
//                 audio.setAttribute('src',e.file);
//                 musicMain.className = e.id;
//             })
//         }
//     }
//
//
//     $('#progress-bar').click(function(e){
//         var x = document.getElementById('progress-bar').getClientRects()[0].x;
//         var coordinate = e.clientX;
//         if(coordinate > x){
//             var newWidth = coordinate - x;
//             $('progress-report').css({"width":newWidth})
//             audio.currentTime = (newWidth * audio.duration)/barWidth;
//             audio.play();
//         }
//     })
//
//     $('#restart').click(function(e){
//         audio.currentTime = 0
//     })
//
//     $('#shuffle').click(function(e){
//         if($("#shuffle").css("color") === "rgb(21, 18, 75)"){
//             $("#shuffle").css({"color" : "blue"})
//         }else $("#shuffle").css({"color" : "rgb(21, 18, 75)"})
//     })
//
// })




