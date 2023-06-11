package co.edu.uniquindio.proyecto.servicios.implementacion;
import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service
@AllArgsConstructor
public class EmailServicioImpl implements EmailServicio {

    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarEmail (EmailDTO emailDTO)
    {

        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);


        try {
            helper.setSubject(emailDTO.getAsunto());
            helper.setText(emailDTO.getCuerpo(), true);
            helper.setTo(emailDTO.getDestinatario());
            helper.setFrom("eduardoe.burbanoc@uqvirtual.com");

            javaMailSender.send(mensaje);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}