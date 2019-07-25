<h1>Registro libro</h1>
<form>
    <div class="form-group">
        <label for="titulo">Titulo del libro</label>
        <input type="text" class="form-control" id="titulo" 
               name="titulo" placeholder="Ingresa el título" 
               required pattern="^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$">
    </div>

    <div class="form-group">
        <label for="autor">Autor</label>
        <input type="text" class="form-control" id="autor" 
               name="autor" placeholder="Ingresa el Autor" 
               required pattern="^([A-ZÁÉÍÓÚ]{1}[a-zñáéíóú]{1,24}[\s]*)+$">
    </div>

    <div class="form-group">
        <label for="isbn">ISBN</label>
        <input type="text" class="form-control" id="isbn" 
               name="isbn" placeholder="Escribe el ISBN sin guiones" 
               required pattern="^[1-9]\d{12}$">
    </div>

    <div class="form-group">
        <label for="numPaginas">Numero de páginas</label>
        <input type="text" class="form-control" id="numPaginas" 
               name="numPaginas" placeholder="Escribe el número de páginas" 
               maxlenght="5" required pattern="^[1-9]\d*$">
    </div>
    <button id="buttonRegistrarLibro" type="submit" style="margin-left: 15px" class="btn btn-success">Registrar</button>
    <button id="buttonCancelar" style="margin-left: 20px" class="btn btn-danger">Cancelar</button>
</form>