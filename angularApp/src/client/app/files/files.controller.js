(function() {
    'use strict';

    angular
        .module('app.files')
        .controller('FilesController', FilesController);

    FilesController.$inject = ['logger', 'FilesService'];
    /* @ngInject */
    function FilesController(logger, FilesService) {
        var vm = this;

        init();

        function init() {
            FilesService.find()
                .then(function(data) {
                        logger.info('Loaded ' + data.length + ' items.');
                        vm.files = data;
                    },
                    // On Error
                    function() {
                        logger.error('Error loading files');
                    });
        }
    }
})();
