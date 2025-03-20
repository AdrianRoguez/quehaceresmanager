# QuehaceresManager - Casos de Uso

## Descripción

La aplicación **QuehaceresManager** permite a los usuarios gestionar sus tareas de manera eficiente. Los usuarios pueden crear, editar, eliminar y marcar tareas como completadas, así como recibir notificaciones sobre sus pendientes. Además, el sistema permite a los usuarios gestionar sus cuentas personales.

---

## Elementos del Diagrama de Casos de Uso

| Elemento                                         | Descripción                                                                               |
|--------------------------------------------------|-------------------------------------------------------------------------------------------|
| **Actor: Usuario**                               | Persona que utiliza la aplicación para gestionar sus tareas.                              |
| **Actor: Sistema**                               | La aplicación que procesa las acciones del usuario.                                       |
| **Actor: Sistema de Notificaciones**             | Sistema externo encargado de enviar recordatorios de tareas.                              |
| **Caso de Uso: Registrar cuenta**                | Permite al usuario crear una nueva cuenta en la aplicación.                               |
| **Caso de Uso: Iniciar sesión**                  | Permite al usuario autenticarse en el sistema.                                            |
| **Caso de Uso: Recuperar contraseña**            | Permite al usuario restablecer su contraseña en caso de olvido.                           |
| **Caso de Uso: Crear una tarea**                 | Permite al usuario agregar una nueva tarea con nombre, fecha de vencimiento y prioridad.  |
| **Caso de Uso: Editar una tarea**                | Permite modificar los datos de una tarea existente.                                       |
| **Caso de Uso: Eliminar una tarea**              | Permite al usuario eliminar una tarea de la lista.                                        |
| **Caso de Uso: Marcar tarea como completada**    | Permite cambiar el estado de una tarea a "Completada".                                    |
| **Caso de Uso: Ver lista de tareas**             | Muestra todas las tareas registradas, organizadas por fecha de vencimiento o prioridad.   |
| **Caso de Uso: Filtrar y ordenar tareas**        | Permite al usuario aplicar filtros y ordenar las tareas por diferentes criterios.         |
| **Caso de Uso: Configurar fecha de vencimiento** | Permite asignar o modificar la fecha de vencimiento de una tarea.                         |
| **Caso de Uso: Enviar Notificación**             | Envía una notificación al Usuario cuando una tarea está próxima a vencer (`<<include>>`). |

---

## Relaciones entre los Elementos

| Relación                                                  | Descripción                                                                                                     |
|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| **Usuario → Registrar cuenta**                            | Asociación: El Usuario puede crear una cuenta para acceder a la aplicación.                                     |
| **Usuario → Iniciar sesión**                              | Asociación: El Usuario debe autenticarse en el sistema para acceder a sus tareas.                               |
| **Usuario → Recuperar contraseña**                        | Asociación: El Usuario puede restablecer su contraseña en caso de olvido.                                       |
| **Usuario → Crear una tarea**                             | Asociación: El Usuario interactúa con el sistema para agregar una nueva tarea.                                  |
| **Usuario → Editar una tarea**                            | Asociación: El Usuario interactúa con el sistema para modificar una tarea existente.                            |
| **Usuario → Eliminar una tarea**                          | Asociación: El Usuario interactúa con el sistema para eliminar una tarea de la lista.                           |
| **Usuario → Marcar tarea como completada**                | Asociación: El Usuario cambia el estado de una tarea a "Completada".                                            |
| **Usuario → Ver lista de tareas**                         | Asociación: El Usuario puede visualizar todas sus tareas organizadas.                                           |
| **Usuario → Filtrar y ordenar tareas**                    | Asociación: El Usuario filtra y ordena las tareas según diferentes criterios.                                   |
| **Usuario → Configurar fecha de vencimiento**             | Asociación: El Usuario asigna o modifica la fecha de vencimiento de una tarea.                                  |
| **Configurar fecha de vencimiento → Enviar Notificación** | **Inclusión** (`<<include>>`): Cuando el usuario establece una fecha de vencimiento, se envía una notificación. |
| **Iniciar sesión → Recuperar contraseña**                 | **Inclusión** (`<<include>>`): Si el usuario olvida su contraseña, puede restablecerla.                         |
| **Registrar cuenta → Iniciar sesión**                     | **Inclusión** (`<<include>>`): Después de registrarse, el usuario debe iniciar sesión.                          |
| **Crear una tarea → Configurar fecha de vencimiento**     | **Inclusión** (`<<include>>`): Cuando se crea una tarea, se puede configurar su fecha de vencimiento.           |
| **Iniciar sesión → Ver lista de tareas**                  | **Extensión** (`<<extend>>`): Al iniciar sesión, el sistema puede mostrar la lista de tareas.                   |
| **Recuperar contraseña → Enviar Notificación**            | **Extensión** (`<<extend>>`): Si un usuario olvida su contraseña, se le envía un correo con instrucciones.      |
| **Enviar Notificación → Recordatorio de Tarea**           | **Extensión** (`<<extend>>`): Se envía un recordatorio adicional si la tarea está próxima a vencer.             |

---

<img src="images/diagrama-casos-de-uso.png">
