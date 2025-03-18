# Casos de Uso - QuehaceresManager

## 1. Actores

- **Usuario**: Persona que utiliza la aplicación para gestionar sus tareas.
- **Sistema**: La aplicación que procesa las acciones del usuario.

---

## 2. Casos de Uso

### **UC01 - Crear una tarea**
**Actor:** Usuario  
**Descripción:** Permite al usuario agregar una nueva tarea con nombre, fecha de vencimiento y prioridad.  
**Flujo principal:**  
1. El usuario selecciona la opción "Agregar tarea".
2. El sistema muestra un formulario para ingresar los detalles de la tarea.
3. El usuario completa el formulario y presiona "Guardar".
4. El sistema almacena la tarea en el fichero y la muestra en la lista de tareas.

---

### **UC02 - Editar una tarea**
**Actor:** Usuario  
**Descripción:** Permite modificar los datos de una tarea existente.  
**Flujo principal:**  
1. El usuario selecciona una tarea y elige la opción "Editar".
2. El sistema muestra los detalles actuales de la tarea.
3. El usuario realiza las modificaciones y presiona "Guardar".
4. El sistema actualiza la tarea en el fichero y refleja los cambios en la lista.

---

### **UC03 - Eliminar una tarea**
**Actor:** Usuario  
**Descripción:** Permite al usuario eliminar una tarea de la lista.  
**Flujo principal:**  
1. El usuario selecciona una tarea y elige la opción "Eliminar".
2. El sistema muestra un mensaje de confirmación.
3. El usuario confirma la eliminación.
4. El sistema borra la tarea del fichero y la elimina.

---

### **UC04 - Marcar tarea como completada**
**Actor:** Usuario  
**Descripción:** Permite cambiar el estado de una tarea a "Completada".  
**Flujo principal:**  
1. El usuario selecciona una tarea y presiona "Marcar como completada".
2. El sistema cambia el estado de la tarea y la muestra visualmente tachada.
3. La tarea se mantiene en la lista pero con un indicador de que ha sido completada.

---

### **UC05 - Ver lista de tareas**
**Actor:** Usuario  
**Descripción:** Muestra todas las tareas registradas, organizadas por fecha de vencimiento o prioridad.  
**Flujo principal:**  
1. El usuario accede a la pantalla principal de la aplicación.
2. El sistema muestra todas las tareas almacenadas, ordenadas según la configuración predeterminada (por fecha o importancia).

---

### **UC06 - Filtrar y ordenar tareas**
**Actor:** Usuario  
**Descripción:** Permite al usuario aplicar filtros y ordenar las tareas por diferentes criterios.  
**Flujo principal:**  
1. El usuario selecciona la opción "Filtrar/Ordenar".
2. El sistema muestra opciones de filtrado (por fecha, prioridad o estado).
3. El usuario elige un criterio y el sistema actualiza la lista de tareas.

---

### **UC07 - Configurar fecha de vencimiento**
**Actor:** Usuario  
**Descripción:** Permite asignar o modificar la fecha de vencimiento de una tarea.  
**Flujo principal:**  
1. El usuario selecciona una tarea y elige "Modificar fecha de vencimiento".
2. El sistema muestra un calendario para elegir la nueva fecha.
3. El usuario selecciona la fecha y confirma la acción.
4. El sistema guarda el cambio y actualiza la vista de la tarea.

---
