 	<form class="form-persona" name="datospersona" action="Persona" method="post">
                  <div class="col-lg-6">
                		<div class="form-group">
                          <label>DNI</label>
                          	<input class="form-control" type="number" name="d" id="d" value="<%=((Persona)session.getAttribute("existedni")).getDni()%>" disabled>
                          	<input class="form-control" type="number" name="dniform" id="dniform" value="<%=((Persona)session.getAttribute("existedni")).getDni()%>" hidden>
                          	
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
                                     <input type="checkbox" value="true" name="habilitado" id="habilitado" <% if(((Persona)session.getAttribute("existedni")).isHabilitado()){%> checked<%} %>>Habilitado
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
                          <select id="categoria" name="categoria" class="form-control">
  						<%	ArrayList<Categoria> categorias = (ArrayList<Categoria>)request.getAttribute("categorias");
           					for(Categoria c : categorias){
           				%>
           				<option id="categoria" name="categoria" value="<%=c.getId() %>" <%if(((Persona)session.getAttribute("existedni")).getCategoria().getDescripcion().equals(c.getDescripcion()) ){%>selected<% } %>><%=c.getDescripcion() %></option>
           				<%} %>
						</select>
					</div>
					<div class="form-group">
					<br>
						<button class="btn btn-warning btn-block" type="submit" >Modificar</button>
					</div>
				</form>
		</div><!-- DiV 6 -->
		
					
                       
                