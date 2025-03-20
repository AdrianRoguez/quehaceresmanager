# QuehaceresManager - Casos de Uso

## Descripción

La aplicación **QuehaceresManager** permite a los usuarios gestionar sus tareas de manera eficiente. Los usuarios pueden crear, editar, eliminar y marcar tareas como completadas, así como recibir notificaciones sobre sus pendientes.

---

## Elementos del Diagrama de Casos de Uso

| Elemento                                         | Descripción                                                                                      |
|--------------------------------------------------|--------------------------------------------------------------------------------------------------|
| **Actor: Usuario**                               | Persona que utiliza la aplicación para gestionar sus tareas.                                     |
| **Actor: Sistema**                               | La aplicación que procesa las acciones del usuario.                                              |
| **Actor: Sistema de Notificaciones**             | Sistema externo encargado de enviar recordatorios de tareas.                                     |
| **Caso de Uso: Crear una tarea**                 | Permite al usuario agregar una nueva tarea con nombre, fecha de vencimiento y prioridad.         |
| **Caso de Uso: Editar una tarea**                | Permite modificar los datos de una tarea existente.                                              |
| **Caso de Uso: Eliminar una tarea**              | Permite al usuario eliminar una tarea de la lista.                                               |
| **Caso de Uso: Marcar tarea como completada**    | Permite cambiar el estado de una tarea a "Completada".                                           |
| **Caso de Uso: Ver lista de tareas**             | Muestra todas las tareas registradas, organizadas por fecha de vencimiento o prioridad.          |
| **Caso de Uso: Filtrar y ordenar tareas**        | Permite al usuario aplicar filtros y ordenar las tareas por diferentes criterios.                |
| **Caso de Uso: Configurar fecha de vencimiento** | Permite asignar o modificar la fecha de vencimiento de una tarea.                                |
| **Caso de Uso: Enviar Notificación**             | Envía una notificación al Usuario cuando una tarea está próxima a vencer (`<<include>>`).        |
| **Caso de Uso: Recordatorio de Tarea**           | Extiende el caso de uso "Enviar Notificación" cuando una tarea está por vencer (`<<extend>>`).   |

---

## Relaciones entre los Elementos

| Relación                                                  | Descripción                                                                                                     |
|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| **Usuario → Crear una tarea**                             | Asociación: El Usuario interactúa con el sistema para agregar una nueva tarea.                                  |
| **Usuario → Editar una tarea**                            | Asociación: El Usuario interactúa con el sistema para modificar una tarea existente.                            |
| **Usuario → Eliminar una tarea**                          | Asociación: El Usuario interactúa con el sistema para eliminar una tarea de la lista.                           |
| **Usuario → Marcar tarea como completada**                | Asociación: El Usuario cambia el estado de una tarea a "Completada".                                            |
| **Usuario → Ver lista de tareas**                         | Asociación: El Usuario puede visualizar todas sus tareas organizadas.                                           |
| **Usuario → Filtrar y ordenar tareas**                    | Asociación: El Usuario filtra y ordena las tareas según diferentes criterios.                                   |
| **Usuario → Configurar fecha de vencimiento**             | Asociación: El Usuario asigna o modifica la fecha de vencimiento de una tarea.                                  |
| **Configurar fecha de vencimiento → Enviar Notificación** | **Inclusión** (`<<include>>`): Cuando el usuario establece una fecha de vencimiento, se envía una notificación. |
| **Enviar Notificación → Recordatorio de Tarea**           | **Extensión** (`<<extend>>`): Si la tarea está próxima a vencer, se envía un recordatorio adicional.            |

---
