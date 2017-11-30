<div class="col-lg-6">
                		<div class="form-group">
                          <label>DNI</label>
                          	<input class="form-control" type="number"  name="dni" id="dni" disabled="" value="<%=((Persona)session.getAttribute("existedni")).getDni()%>">
                          	
                        </div>
                        <div class="form-group">
                          <label>Nombre</label>
                          	<input class="form-control" type="text" name="nombre" id="nombre" value="<%=((Persona)session.getAttribute("existedni")).getNombre()%>">
                        </div>
                        <div class="form-group">
                          <label>Apellido</label>
                          	<input class="form-control" type="text" name="apellido" id="apellido" value="<%=((Persona)session.getAttribute("existedni")).getApellido()%>" >
                        </div>
                        <div class="form-group">
                          	<label>Estado</label>
                            	<div class="checkbox">
                                   <label>
                                     <input type="checkbox" value="admin" <% if(((Persona)session.getAttribute("existedni")).isHabilitado()){%> checked<%} %>>Habilitado
                                   </label>
                                </div>
                                </div>
                    </div>
                    <div class="col-lg-6">
                		<div class="form-group">
                          <label>Usuario</label>
                          	<input class="form-control" type="text" name="usuario" id="usuario" value="<%=((Persona)session.getAttribute("existedni")).getUss()%>" >
                        </div>
                        <div class="form-group">
                          <label>Contraseña</label>
                          	<input class="form-control" type="password" name="pass" id="pass" value="<%=((Persona)session.getAttribute("existedni")).getPass()%>">
                        </div>
                        <div class="form-group">
                        <label>Categoria</label>
                          <select class="form-control">
  						<%	ArrayList<Categoria> categorias = (ArrayList<Categoria>)request.getAttribute("categorias");
           					for(Categoria c : categorias){
           				%>
           				<option value="<%=c.getDescripcion() %>" <%if(((Persona)session.getAttribute("existedni")).getCategoria().getDescripcion().equals(c.getDescripcion()) ){%>selected<% } %>><%=c.getDescripcion() %></option>
           				<%} %>
						</select>
					</div>
					<div class="form-group">
					<br>
						<button class="btn btn-warning btn-block" >Modificar</button>
					</div>
			
		</div><!-- DiV 6 -->
		
					
                       
                