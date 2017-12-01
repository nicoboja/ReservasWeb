 <form class="form-persona" name="datospersona" action="Persona" method="post">
            <div class="col-lg-6">
                		<div class="form-group">
                          <label>DNI</label>
                          	<input class="form-control" type="number"  name="d" id="d" disabled="" value="<%=session.getAttribute("nuevodni")%>">
                          	<input class="form-control" type="number" name="dniform" id="dniform"  required="" value="<%=session.getAttribute("nuevodni")%>" hidden>
                          	
                        </div>
                       
                        <div class="form-group">
                          <label>Nombre</label>
                          	<input class="form-control" type="text" name="nombre" id="nombre" required=""  >
                        </div>
                        <div class="form-group">
                          <label>Apellido</label>
                          	<input class="form-control" type="text" name="apellido" id="apellido" required=""  >
                        </div>
                        <div class="form-group">
                          	<label>Estado</label>
                            	<div class="checkbox" >
                                   <label>
                                     <input type="checkbox" value="true" id="habilitado" name="habilitado">Habilitado
                                   </label>
                                </div>
                                </div>
                    </div>
                    <div class="col-lg-6">
                		<div class="form-group">
                          <label>Usuario</label>
                          	<input class="form-control" type="text" name="usuario" id="usuario" >
                        </div>
                        <div class="form-group">
                          <label>Contraseña</label>
                          	<input class="form-control" type="password" name="pass" id="pass" >
                        </div>
                        <div class="form-group">
                        <label>Categoria</label>
                          <select id="categoria" name="categoria" class="form-control">
  						<%	ArrayList<Categoria> categorias = (ArrayList<Categoria>)request.getAttribute("categorias");
           					for(Categoria c : categorias){
           				%>
           				<option id="categoria" name="categoria" value="<%=c.getId() %>"><%=c.getDescripcion()%></option>
           				<%} %>
						</select>
					</div>
		

					<div class="form-group">
					<br>
						<button class="btn btn-success btn-block" type="submit" >Guardar</button>
					</div>
                       
        </div>

