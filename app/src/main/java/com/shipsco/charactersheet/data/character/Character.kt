package com.shipsco.charactersheet.data.character

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "character")
@Serializable
data class Character(
    @PrimaryKey(autoGenerate = false)
    var characterName: String = "",
    var editingIsLocked: Boolean = false,
    var classLevel: String = "",
    var background: String = "",
    var playerName: String = "",
    var race: String = "",
    var alignmentType: String = "",
    var experiencePoints: String = "",
    var totalLevel: String = "",
    var armorClass: String = "",
    var initiative: String = "",
    var speed: String = "",
    var hitPointMax: String = "",
    var currentHitPoints: String = "",
    var temporaryHitPoints: String = "",
    var totalHitDice: String = "",
    var hitDice: String = "",
    var successDeathSave1: Boolean = false,
    var successDeathSave2: Boolean = false,
    var successDeathSave3: Boolean = false,
    var failDeathSave1: Boolean = false,
    var failDeathSave2: Boolean = false,
    var failDeathSave3: Boolean = false,
    var inspiration: Boolean = false,
    var proficiencyBonus: String = "",
    var strength: String = "",
    var strengthBonus: String = "",
    var dexterity: String = "",
    var dexterityBonus: String = "",
    var constitution: String = "",
    var constitutionBonus: String = "",
    var intelligence: String = "",
    var intelligenceBonus: String = "",
    var wisdom: String = "",
    var wisdomBonus: String = "",
    var charisma: String = "",
    var charismaBonus: String = "",
    var strengthSaveChecked: Boolean = false,
    var strengthSave: String = "",
    var dexteritySaveChecked: Boolean = false,
    var dexteritySave: String = "",
    var constitutionSaveChecked: Boolean = false,
    var constitutionSave: String = "",
    var intelligenceSaveChecked: Boolean = false,
    var intelligenceSave: String = "",
    var wisdomSaveChecked: Boolean = false,
    var wisdomSave: String = "",
    var charismaSaveChecked: Boolean = false,
    var charismaSave: String = "",
    var acrobaticsChecked: Boolean = false,
    var acrobatics: String = "",
    var animalHandlingChecked: Boolean = false,
    var animalHandling: String = "",
    var arcanaChecked: Boolean = false,
    var arcana: String = "",
    var athleticsChecked: Boolean = false,
    var athletics: String = "",
    var deceptionChecked: Boolean = false,
    var deception: String = "",
    var historyChecked: Boolean = false,
    var history: String = "",
    var insightChecked: Boolean = false,
    var insight: String = "",
    var intimidationChecked: Boolean = false,
    var intimidation: String = "",
    var investigationChecked: Boolean = false,
    var investigation: String = "",
    var medicineChecked: Boolean = false,
    var medicine: String = "",
    var natureChecked: Boolean = false,
    var nature: String = "",
    var perceptionChecked: Boolean = false,
    var perception: String = "",
    var performanceChecked: Boolean = false,
    var performance: String = "",
    var persuasionChecked: Boolean = false,
    var persuasion: String = "",
    var religionChecked: Boolean = false,
    var religion: String = "",
    var sleightOfHandChecked: Boolean = false,
    var sleightOfHand: String = "",
    var stealthChecked: Boolean = false,
    var stealth: String = "",
    var survivalChecked: Boolean = false,
    var survival: String = "",
    var attackSpells: MutableList<AttackSpell> = blankAttackSpell,
    var copper: String = "",
    var silver: String = "",
    var electrum: String = "",
    var gold: String = "",
    var platinum: String = "",
    var equipment: String = "",
    var featuresTraits: String = "",
    var proficiencyLanguages: String = "",
    var personalityTraits: String = "",
    var ideals: String = "",
    var bonds: String = "",
    var flaws: String = "",
    var spellCastingClass: String = "",
    var spellCastingAbility: String = "",
    var spellSaveDC: String = "",
    var spellAttackBonus: String = "",
    var cantrips: MutableList<String> = MutableList(8) { "" },
    var spells:  List<Spell> = blankSpells,
    var notesMisc: MutableList<MutableList<String>> = MutableList(1){ mutableListOf("","") },
    var selectedNote: String = notesMisc[0][0]
)

val blankCharacter = Character(
    characterName = "",
    editingIsLocked = false,
    classLevel = "",
    background = "",
    playerName = "",
    race = "",
    alignmentType = "",
    experiencePoints = "",
    totalLevel = "",
    armorClass = "",
    initiative = "",
    speed = "",
    hitPointMax = "",
    currentHitPoints = "",
    temporaryHitPoints = "",
    totalHitDice = "",
    hitDice = "",
    successDeathSave1 = false,
    successDeathSave2 = false,
    successDeathSave3 = false,
    failDeathSave1 = false,
    failDeathSave2 = false,
    failDeathSave3 = false,
    inspiration = false,
    proficiencyBonus = "",
    strength = "",
    strengthBonus = "",
    dexterity = "",
    dexterityBonus = "",
    constitution = "",
    constitutionBonus = "",
    intelligence = "",
    intelligenceBonus = "",
    wisdom = "",
    wisdomBonus = "",
    charisma = "",
    charismaBonus = "",
    strengthSaveChecked = false,
    strengthSave = "",
    dexteritySaveChecked = false,
    dexteritySave = "",
    constitutionSaveChecked = false,
    constitutionSave = "",
    intelligenceSaveChecked = false,
    intelligenceSave = "",
    wisdomSaveChecked = false,
    wisdomSave = "",
    charismaSaveChecked = false,
    charismaSave = "",
    acrobaticsChecked = false,
    acrobatics = "",
    animalHandlingChecked = false,
    animalHandling = "",
    arcanaChecked = false,
    arcana = "",
    athleticsChecked = false,
    athletics = "",
    deceptionChecked = false,
    deception = "",
    historyChecked = false,
    history = "",
    insightChecked = false,
    insight = "",
    intimidationChecked = false,
    intimidation = "",
    investigationChecked = false,
    investigation = "",
    medicineChecked = false,
    medicine = "",
    natureChecked = false,
    nature = "",
    perceptionChecked = false,
    perception = "",
    performanceChecked = false,
    performance = "",
    persuasionChecked = false,
    persuasion = "",
    religionChecked = false,
    religion = "",
    sleightOfHandChecked = false,
    sleightOfHand = "",
    stealthChecked = false,
    stealth = "",
    survivalChecked = false,
    survival = "",
    attackSpells = blankAttackSpell,
    copper = "",
    silver = "",
    electrum = "",
    gold = "",
    platinum = "",
    equipment = "",
    featuresTraits = "",
    proficiencyLanguages = "",
    personalityTraits = "",
    ideals = "",
    bonds = "",
    flaws = "",
    spellCastingClass = "",
    spellCastingAbility = "",
    spellSaveDC = "",
    spellAttackBonus = "",
    cantrips = MutableList(8) {""},
    spells = blankSpells,
    notesMisc = mutableListOf(
        mutableListOf("General",""),
        mutableListOf("Cantrips",""),
        mutableListOf("Level 1 Spells",""),
        mutableListOf("Level 2 Spells",""),
        mutableListOf("Level 3 Spells",""),
        mutableListOf("Level 4 Spells",""),
        mutableListOf("Level 5 Spells",""),
        mutableListOf("Level 6 Spells",""),
        mutableListOf("Level 7 Spells",""),
        mutableListOf("Level 8 Spells",""),
        mutableListOf("Level 9 Spells","")
    ),
    selectedNote = "General"
)

val testCharacter = Character(
    characterName = "1",
    editingIsLocked = false,
    classLevel = "2",
    background = "3",
    playerName = "4",
    race = "5",
    alignmentType = "6",
    experiencePoints = "7",
    totalLevel = "7.5",
    armorClass = "8",
    initiative = "9",
    speed = "10",
    hitPointMax = "11",
    currentHitPoints = "12",
    temporaryHitPoints = "13",
    totalHitDice = "14",
    hitDice = "15",
    successDeathSave1 = false,
    successDeathSave2 = false,
    successDeathSave3 = false,
    failDeathSave1 = false,
    failDeathSave2 = false,
    failDeathSave3 = false,
    inspiration = false,
    proficiencyBonus = "17",
    strength = "18",
    strengthBonus = "19",
    dexterity = "20",
    dexterityBonus = "21",
    constitution = "22",
    constitutionBonus = "23",
    intelligence = "24",
    intelligenceBonus = "25",
    wisdom = "26",
    wisdomBonus = "27",
    charisma = "28",
    charismaBonus = "29",
    strengthSaveChecked = false,
    strengthSave = "30",
    dexteritySaveChecked = false,
    dexteritySave = "31",
    constitutionSaveChecked = false,
    constitutionSave = "32",
    intelligenceSaveChecked = false,
    intelligenceSave = "33",
    wisdomSaveChecked = false,
    wisdomSave = "34",
    charismaSaveChecked = false,
    charismaSave = "35",
    acrobaticsChecked = false,
    acrobatics = "36",
    animalHandlingChecked = false,
    animalHandling = "37",
    arcanaChecked = false,
    arcana = "38",
    athleticsChecked = false,
    athletics = "39",
    deceptionChecked = false,
    deception = "40",
    historyChecked = false,
    history = "41",
    insightChecked = false,
    insight = "42",
    intimidationChecked = false,
    intimidation = "43",
    investigationChecked = false,
    investigation = "44",
    medicineChecked = false,
    medicine = "45",
    natureChecked = false,
    nature = "46",
    perceptionChecked = false,
    perception = "47",
    performanceChecked = false,
    performance = "48",
    persuasionChecked = false,
    persuasion = "49",
    religionChecked = false,
    religion = "50",
    sleightOfHandChecked = false,
    sleightOfHand = "51",
    stealthChecked = false,
    stealth = "52",
    survivalChecked = false,
    survival = "53",
    attackSpells = blankAttackSpell,
    copper = "54",
    silver = "55",
    electrum = "56",
    gold = "57",
    platinum = "58",
    equipment = "59",
    featuresTraits = "59.5",
    proficiencyLanguages = "60",
    personalityTraits = "61",
    ideals = "62",
    bonds = "63",
    flaws = "64",
    spellCastingClass = "65",
    spellCastingAbility = "66",
    spellSaveDC = "67",
    spellAttackBonus = "67",
    cantrips = MutableList(8) { "68" },
    spells = blankSpells,
    notesMisc = MutableList(1) { mutableListOf("69","70") },
    selectedNote = "69"

)