<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:key name="cicloKey" match="Alumno" use="Ciclo" />
  <xsl:template match="/">
    <html>
      <head>
        <title>Alumnos por Ciclo</title>
        <style>
          body { font-family: 'Segoe UI', sans-serif; background-color: #f4f4f4; color: #333; margin: 40px; }
          h1 { text-align: center; color: #1976d2; }
          h2 { color: #0d47a1; margin-top: 40px; }
          table { border-collapse: collapse; width: 80%; margin: 10px auto; border-radius: 8px; overflow: hidden; box-shadow: 0 0 10px rgba(0,0,0,0.2); }
          th, td { padding: 8px 12px; text-align: center; }
          th { background-color: #2196f3; color: #fff; }
          tr:nth-child(even) { background-color: #e3f2fd; }
          .grupo-A { background-color: #c8e6c9; }
          .grupo-B { background-color: #ffccbc; }
          .grupo-Dam { background-color: #fff9c4; }
        </style>
      </head>
      <body>
        <h1>Alumnos por Ciclo</h1>
        <xsl:for-each select="Alumnos/Alumno[generate-id() = generate-id(key('cicloKey', Ciclo)[1])]">
          <h2><xsl:value-of select="Ciclo"/></h2>
          <table>
            <tr>
              <th>NIA</th>
              <th>Nombre</th>
              <th>Apellidos</th>
              <th>Curso</th>
              <th>Grupo</th>
              <th>Fecha de Nacimiento</th>
            </tr>
            <xsl:for-each select="key('cicloKey', Ciclo)">
              <tr>
                <td><xsl:value-of select="Nia"/></td>
                <td><xsl:value-of select="Nombre"/></td>
                <td><xsl:value-of select="Apellidos"/></td>
                <td><xsl:value-of select="Curso"/></td>
                <td>
                  <xsl:attribute name="class">
                    <xsl:text>grupo-</xsl:text><xsl:value-of select="Grupo"/>
                  </xsl:attribute>
                  <xsl:value-of select="Grupo"/>
                </td>
                <td><xsl:value-of select="Fecha_Nacimiento"/></td>
              </tr>
            </xsl:for-each>
          </table>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>