package com.example.tmf629.mapper.party;

import com.example.tmf629.dto.party.RelatedPartyOrPartyRoleRefDTO;
import com.example.tmf629.model.party.RelatedPartyOrPartyRoleRef;

public class RelatedPartyOrPartyRoleRefMapper {
    public static RelatedPartyOrPartyRoleRefDTO toDto(RelatedPartyOrPartyRoleRef entity) {
        if (entity == null) {
            return null;
        }
        return RelatedPartyOrPartyRoleRefDTO.builder()
                .partyOrPartyRole(
                        PartyRefMapper.toDto(entity.getPartyOrPartyRole())
                )
                .role(entity.getRole())
                .baseType(entity.getBaseType())
                .type(entity.getType())
                .build();
    }
    public static RelatedPartyOrPartyRoleRef toEntity(RelatedPartyOrPartyRoleRefDTO dto) {
        if (dto == null) {
            return null;
        }
        return RelatedPartyOrPartyRoleRef.builder()
                .partyOrPartyRole(
                        PartyRefMapper.toEntity(dto.getPartyOrPartyRole())
                )
                .role(dto.getRole())
//                .baseType(dto.getBaseType())
//                .type(dto.getType())
                .build();
    }
}
