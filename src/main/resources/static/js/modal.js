$(document).ready(function () {
    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        $(".col #deelnemer-name").val( recipient );
    });
});
