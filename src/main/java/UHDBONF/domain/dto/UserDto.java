package UHDBONF.domain.dto;

import UHDBONF.domain.common.BaseTimeDto;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class UserDto extends BaseTimeDto<UserDto> implements UserDetails {
    private String uid;
    private String tid;
    private String region;
    private String tnickName;

    private List<MessageDto> message;
    private List<LuckyDrawDto> luckyDraws;

    public UserDto(String tid){
        this.tid = tid;
    }
    public UserDto() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
