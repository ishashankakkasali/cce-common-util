package org.openphc.cce.common.event;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Published to cce.intelligence.triggers when an intelligence action fires.
 * Consumed by the CCE Intelligence Service for intelligence destination routing and delivery.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntelligenceTriggerEvent {

    private UUID id;
    private String subject;
    private UUID intelligenceEventId;
    private UUID actionDefinitionId;
    private UUID protocolDefinitionId;
    private String actionType;
    private String severity;
    private String intelligenceDestination;
    private String stepStatus;

    private String slaStatus;
    /** The step the intelligence action sits under (e.g. "follow-up-visit"). */
    private String actionId;
    /** The intelligence action that fired (e.g. "follow-up-visit-overdue-alert"). */
    private String intelligenceActionId;
    /** The intelligence action's title from the PlanDefinition, when it has one. */
    private String title;
    /**
     * The kind of communication, when the intelligence action declares one: an HL7
     * communication-category code (alert, notification, reminder, instruction).
     */
    private String category;
    /**
     * Who the intelligence action is for, from its PlanDefinition {@code participant.type}: patient,
     * practitioner, related-person or device. Absent when it declares none.
     */
    private List<String> participantTypes;
    /** Why it fired: "completion", or the lowercase deviation type ("overdue", "missed", "order_violation"). */
    private String triggerReason;
    private String protocolCanonical;
    private OffsetDateTime detectedAt;
    private JsonNode eventPayload;
}
