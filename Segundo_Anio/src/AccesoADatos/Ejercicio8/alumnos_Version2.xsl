<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Listado de Alumnos</title>
        <style>
          body { font-family: Arial, sans-serif; background-color: #f8f8f8; color: #333; margin: 30px; }
          h2 { color: #1e88e5; text-align: center; }
          table { border-collapse: collapse; width: 90%; margin: auto; box-shadow: 0 0 10px rgba(0,0,0,0.2); }
          th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }
          th { background-color: #1e88e5; color: white; }
          tr:nth-child(even) { background-color: #e3f2fd; }
          tr:hover { background-color: #bbdefb; }
        </style>
      </head>
      <body>
        <h2>Listado de Alumnos</h2>
        <table>
          <tr>
            <th>NIA</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Ciclo</th>
            <th>Curso</th>
            <th>Grupo</th>
            <th>Género</th>
            <th>Fecha de Nacimiento</th>
          </tr>
          <xsl:for-each select="Alumnos/Alumno">
            <tr>
              <td><xsl:value-of select="Nia"/></td>
              <td><xsl:value-of select="Nombre"/></td>
              <td><xsl:value-of select="Apellidos"/></td>
              <td><xsl:value-of select="Ciclo"/></td>
              <td><xsl:value-of select="Curso"/></td>
              <td><xsl:value-of select="Grupo"/></td>
              <td><xsl:value-of select="Genero"/></td>
              <td><xsl:value-of select="Fecha_Nacimiento"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>