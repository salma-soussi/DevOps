(function($) {
  'use strict';
  $(function() {
    $('.file-upload-browse').on('click', function() {
      var file = $(this).parent().parent().parent().find('.file-upload-default');
      file.trigger('click');
    });
    $('.file-upload-default').on('change', function() {
    var files = $(this).prop("files");
    console.log(files);
    var names = $.map(files, function(val) { return val.name; });
      $(this).parent().find('.form-control').val(names);
    });
  });
})(jQuery);
