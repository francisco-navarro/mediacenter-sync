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
        vm.discard = discard;
        vm.find = find;

        init();

        function init() {
            vm.statusFilter = 'PENDING';
            find();
        }

        function find() {
            FilesService.find(vm.statusFilter)
                .then(function(data) {
                        logger.info('Loaded ' + data.length + ' items.');
                        vm.files = data;
                    },
                    // On Error
                    function() {
                        logger.error('Error loading files');
                    });
        }

        function save(item) {
            FilesService.save(item)
                .then(find());
        }

        function discard(item) {
            FilesService.discard(item)
                .then(find());
        }
    }
})();
