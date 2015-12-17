(function() {
    'use strict';

    angular
        .module('app.files')
        .controller('FilesController', FilesController);

    /* @ngInject */
    function FilesController(FilesService, $timeout) {
        var vm = this;
        vm.save = save;
        vm.discard = discard;
        vm.find = find;
        vm.reset = reset;

        init();

        function init() {
            vm.statusFilter = 'PENDING';
            find();
        }

        function find() {
            FilesService.find(vm.statusFilter)
                .then(function(data) {
                        console.info('Loaded ' + data.length + ' items.');
                        vm.files = data;
                    },
                    // On Error
                    function() {
                        console.error('Error loading files');
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

        function reset(item) {
            FilesService.reset(item)
                .then(find());
        }
    }
})();
