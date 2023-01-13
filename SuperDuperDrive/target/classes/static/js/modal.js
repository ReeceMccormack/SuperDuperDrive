// For opening the note modal
            function showNoteModal(noteId, noteTitle, noteDescription) {
                $('#note-id').val(noteId ? noteId : '');
                $('#note-title').val(noteTitle ? noteTitle : '');
                $('#note-description').val(noteDescription ? noteDescription : '');
                $('#noteModal').modal('show');
            }

            // For opening the credentials modal
            function showCredentialModal(credentialId, url, username, password) {
                $('#credential-id').val(credentialId ? credentialId : '');
                $('#credential-url').val(url ? url : '');
                $('#credential-username').val(username ? username : '');
                $('#credential-password').val(password ? password : '');
                $('#credentialModal').modal('show');
            }

            function hideMessage() {
             var x = document.getElementById("message");
                x.style.visibility="hidden"
              }