(function() {
    'use strict';

    angular
        .module('app.files')
        .controller('FilesController', FilesController);

    FilesController.$inject = ['logger', 'FilesService'];
    /* @ngInject */
    function FilesController(logger, FilesService) {
        var vm = this;
        vm.save = save;

        init();

        function init() {
            find();
        }

        function find(status) {
            FilesService.find(status)
                .then(function(data) {
                        logger.info('Loaded ' + data.length + ' items.');
                        vm.files = data;
                    },
                    // On Error
                    function() {
                        logger.error('Error loading files');
                    });
        }

        function download(item) {
            FilesService.download(item);
        }

        function discard(item) {
            FilesService.discard(item);
        }
    }
})();
