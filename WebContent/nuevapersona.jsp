<div class="col-lg-6">
                		<div class="form-group">
                          <label>DNI</label>
                          	<input class="form-control" type="number"  name="dni" id="dni" disabled="" value="<%=session.getAttribute("nuevodni")%>">
                          	
                        </div>
                       
                        <div class="form-group">
                          <label>Nombre</label>
                          	<input class="form-control" type="text" name="nombre" id="nombre" disabled="" >
                        </div>
                        <div class="form-group">
                          <label>Apellido</label>
                          	<input class="form-control" type="text" name="apellido" id="apellido" disabled="" >
                        </div>
                        <div class="form-group">
                          	<label>Estado</label>
                            	<div class="checkbox" disabled="">
                                   <label>
                                     <input type="checkbox" value="admin" disabled="">Habilitado
                                   </label>
                                </div>
                                </div>
                    </div>
                    <div class="col-lg-6">
                		<div class="form-group">
                          <label>Usuario</label>
                          	<input class="form-control" type="text" name="usuario" id="usuario" disabled="">
                        </div>
                        <div class="form-group">
                          <label>Contraseña</label>
                          	<input class="form-control" type="password" name="pass" id="pass" disabled="">
                        </div>
                        <div class="form-group">
                        <label>Categoria</label>
                          <select class="form-control">
  						<%	ArrayList<Categoria> categorias = (ArrayList<Categoria>)request.getAttribute("categorias");
           					for(Categoria c : categorias){
           				%>
           				<option disabled=""><%=c.getDescripcion() %></option>
           				<%} %>
						</select>
					</div>
		

					<div class="form-group">
					<br>
						<button class="btn btn-success btn-block" >Guardar</button>
					</div>
                       
                    </div>
                    </div>
                </div>