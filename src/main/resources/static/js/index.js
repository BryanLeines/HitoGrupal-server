jQuery(document).ready(function() {
    if (jQuery('.aqua').length) {
        var words = [
                'Pop.',
                'Hip-hop.',
                '<i class="fas fa-grin-hearts"></i>',
                'Rock.',
                'Rap.',
                'Electronic.',
                'Country.',
                'Study.',
                'Jazz.',
                'Latin.',
                'Arabic.',
                'Asian.',
                'Classical.',
                'House.',
                'Disco.',
                '<i class="fas fa-smile-wink"></i>'
            ],

            i = 0;
        setInterval(function(){
            jQuery('.aqua').fadeOut(function(){
                jQuery(this).html(words[i=(i+1)%words.length]).fadeIn();
            });
        }, 1000);
    }
});

$(document).ready(function() {
    $('a[href^="#"]').click(function() {
        var destino = $(this.hash);
        if (destino.length == 0) {
            destino = $('a[name="' + this.hash.substr(1) + '"]');
        }
        if (destino.length == 0) {
            destino = $('html');
        }
        $('html, body').animate({ scrollTop: destino.offset().top }, 500);
        return false;
    });
});